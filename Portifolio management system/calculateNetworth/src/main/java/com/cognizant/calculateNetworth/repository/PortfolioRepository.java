package com.cognizant.calculateNetworth.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.calculateNetworth.model.Portfolio;


public interface PortfolioRepository extends JpaRepository<Portfolio,Integer>{

}
