package com.cognizant.calculateNetworth.service;

import java.util.List;

import com.cognizant.calculateNetworth.model.Asset;

public interface AssetService {
	public List<Asset> getAllAssetForPortfolio(int id);

}
