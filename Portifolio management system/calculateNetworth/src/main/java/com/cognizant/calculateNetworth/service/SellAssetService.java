package com.cognizant.calculateNetworth.service;

import java.util.Map;

public interface SellAssetService {
	public void deleteStockAssetWithUnits(int portfolioId,Map<String,Integer> idList);
	public void deleteMutualFundAssetWithUnits(int portfolioId,Map<String, Integer> mfIdList);
	public Boolean isSessionValid(String token) ;

}
