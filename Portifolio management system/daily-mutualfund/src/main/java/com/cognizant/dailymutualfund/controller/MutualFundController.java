package com.cognizant.dailymutualfund.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.dailymutualfund.exception.MutualFundNotFoundException;
import com.cognizant.dailymutualfund.model.MutualFund;
import com.cognizant.dailymutualfund.service.MutualFundService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class MutualFundController {

	@Autowired
	private MutualFundService service;


	@GetMapping("/MutualFunds-Information")
	public List<MutualFund> getAllMutualFunds(@RequestHeader("Authorization") String token) {
		log.info("START :: Method :: getAllMutualFund() ::");
		if (service.isSessionValid(token)) {
			log.debug("Started fetching all mutual funds after authorization");
			return service.getAllMutualFunds();
		}
		return Collections.emptyList();

	}
  
	
	@GetMapping("/MutualFundByName/{mutualFundName}")  
	public MutualFund getMutualFundByName(@RequestHeader("Authorization") String token, @PathVariable String mutualFundName) throws MutualFundNotFoundException {
		log.info("In getDailyMutualFundNavById Controller");
		if (service.isSessionValid(token)) {
			MutualFund mf = service.getMutualFundByName(mutualFundName);
			if(mf != null) {
				return mf;
			}
			else {  
				throw new MutualFundNotFoundException(" No mutualfund with the name "+mutualFundName+" present!");
			}
		}
		return null;
	}

	
	@GetMapping("/MutualFundById/{mutualFundId}")
	public MutualFund getMutualFundById(@RequestHeader("Authorization") String token, @PathVariable(value = "mutualFundId") String mutualFundId) throws MutualFundNotFoundException 
	{

		log.info("In getDailyMutualFundNavById Controller");
		if (service.isSessionValid(token)) {
			MutualFund mf = service.getMutualFundById(mutualFundId);
			if(mf != null) {
				return mf;
			}
			else {  
				throw new MutualFundNotFoundException(" No mutualfund with the ID "+mutualFundId+" present!");
			}
		}
		return null;
	}

	@GetMapping("/MutualFundByIdList/{mutualFundId}")
	public List<Double> getMutualFundByIdList(@RequestHeader("Authorization") String token, @PathVariable(value = "mutualFundId") List<String> mutualFundIdList) throws MutualFundNotFoundException {
		if (service.isSessionValid(token)) {			
			List<Double> mfs = service.getMutualFundByIdList(mutualFundIdList);
			if(mfs != null) {
				return mfs;
			}
			else {  
				throw new MutualFundNotFoundException(" No mutualfunds present!");
			}
		} 
		return null;
	}
	
	
}
