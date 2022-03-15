package com.cognizant.webservice.model;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellObjectMap {

	int pid;

	Map<String,Integer> stockIdList;

	Map<String,Integer> mfAssetList;
}