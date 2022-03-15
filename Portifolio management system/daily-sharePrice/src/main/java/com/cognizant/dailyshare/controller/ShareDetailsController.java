package com.cognizant.dailyshare.controller;
import java.util.Collections;
/**
 * @author Ruksar, Revathi, Rameswara, Prachi
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


import com.cognizant.dailyshare.exception.ShareNotFoundException;
import com.cognizant.dailyshare.model.ShareDetails;
import com.cognizant.dailyshare.service.ShareDetailsService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class ShareDetailsController {
	
	@Autowired
	private ShareDetailsService service;
	
	@GetMapping("/getAllShares")
	public List<ShareDetails> getAllShares(@RequestHeader("Authorization") String token){
		log.info("START :: Method :: getAllShares() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching all shares after authorization");
			List<ShareDetails> sds = service.getAllShares();
			return sds;
		}
		return Collections.emptyList();
		
	}
	

	@GetMapping("/getShare/shareName/{shareName}")
	public ShareDetails getShareByShareName(@RequestHeader("Authorization") String token,@PathVariable String shareName) throws ShareNotFoundException {
		log.info("START :: Method :: getShareByShareName() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching share with particular share name after authorization");
			ShareDetails sd = service.getShareByShareName(shareName);
			if(sd == null) {
				throw new ShareNotFoundException(shareName+" not found! *************");
			}
			else {
				return sd;
			}
		}		
		return null;
	}
	
	 
	@GetMapping("/getShare/shareId/{shareId}")
	public ShareDetails getShareByShareId(@RequestHeader("Authorization") String token,@PathVariable String shareId) throws ShareNotFoundException {
		log.info("START :: Method :: getShareByShareId() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching share with particular share id after authorization");
			
		 	ShareDetails sd = service.getShareByShareId(shareId);
		 	if(sd == null) {
		 		throw new ShareNotFoundException(shareId+" Not found! **************");
		 	}
		 	else {
		 		return sd;
		 	}
		 }
		return null;
	}
	
//	@GetMapping("/dailySharePrice/shareIdList/{shareId}")	

	
	@GetMapping("/getShareValuesByShareIdList/shareIdList/{shareId}")	
	public List<Double> getShareValuesByShareIdList(@RequestHeader("Authorization") String token,@PathVariable(value="shareId") List<String> shareIdList){
		log.info("START :: Method :: getShareValuesByShareIdList() ::");
		if(service.isSessionValid(token)) {
			log.debug("Started fetching list of stock values after authorization");
			return service.getShareValuesByShareIdList(shareIdList);
		}
		return null;
	}
	
	
	
}
