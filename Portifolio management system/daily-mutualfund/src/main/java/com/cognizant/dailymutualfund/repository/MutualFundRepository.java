package com.cognizant.dailymutualfund.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.dailymutualfund.model.MutualFund;
/**
 * This is the repository layer 
 * 
 */
public interface MutualFundRepository extends JpaRepository<MutualFund,String>{
	
	public List<MutualFund> findAll();
	
	public MutualFund findByMutualFundName(String mutualFundName);
	

	 @Query("SELECT m FROM MutualFund m WHERE m.mutualFundId IN (:mutualFundIdList) order by m.mutualFundId")
	 public List<MutualFund> findByMutualFundId(@Param("mutualFundIdList") List<String> mutualFundIdList);
	 
	 public MutualFund findByMutualFundId(@Param("mutualFundIdList") String mutualFundId);
	
	
	 @Query("select new com.cognizant.dailymutualfund.model.MutualFund(m.mutualFundValue) from MutualFund m where m.mutualFundId = ?1")
	 public List<MutualFund> customValues(String id);
 
}
