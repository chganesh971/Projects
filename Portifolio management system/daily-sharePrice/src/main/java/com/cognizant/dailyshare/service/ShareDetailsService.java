package com.cognizant.dailyshare.service;

import java.util.List;

import com.cognizant.dailyshare.model.ShareDetails;



public interface ShareDetailsService {
	
	public List<ShareDetails> getAllShares();
	
	public ShareDetails getShareByShareName(String shareName) ;
	
	public ShareDetails getShareByShareId(String shareId);
	
	public List<Double> getShareValuesByShareIdList(List<String> shareIdList);
	
	 public Boolean isSessionValid(String token);
	
	
}
