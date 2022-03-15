package com.cognizant.calculateNetworth.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.calculateNetworth.controller.AuthClient;
import com.cognizant.calculateNetworth.model.Asset;
import com.cognizant.calculateNetworth.model.AuthResponse;
import com.cognizant.calculateNetworth.repository.AssetRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the service implementation layer for SellAsset
 *
 */
@Service
@Slf4j
public class SellAssetServiceImpl implements SellAssetService{
	
	@Autowired
	private AssetRepository repository;
	
	@Autowired
	private AuthClient authClient;
	
	
	public void deleteStockAssetWithUnits(int portfolioId,Map<String,Integer> idList) {   // ( key, value )
		log.info("In service DeleteStockAssets");
		for(String id:idList.keySet()) {
			log.debug("Portfolio Details:{}",repository.findByPortfolioidAndAssetidAndType(portfolioId,id,"Share"));
		Asset a = repository.findByPortfolioidAndAssetidAndType(portfolioId,id,"Share");
		int units=a.getUnits()-idList.get(id);			// 20 - 10 => 10
		log.info("Ended service DeleteStockAssets");
		if(units>0) {
			a.setUnits(units);
			repository.save(a);
		}
		else {
			repository.delete(a);
		}
		}
	}
	
	public void deleteMutualFundAssetWithUnits(int portfolioId,Map<String, Integer> mfIdList) {
		log.info("In service DeleteMutualFundsAssets");
		for(String id:mfIdList.keySet()) {
			log.debug("Portfolio Details:{}",repository.findByPortfolioidAndAssetidAndType(portfolioId,id,"MF"));
			Asset a = repository.findByPortfolioidAndAssetidAndType(portfolioId,id,"MF");
			int units=a.getUnits()-mfIdList.get(id);
			log.info("Ended service DeleteMutualFundsAssets");
			if(units>0) {
				a.setUnits(units);
				repository.save(a);
			}
			else {
				repository.delete(a);
			}
			}
	}
	
	public Boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		} 
		return true;
	}
	

}
