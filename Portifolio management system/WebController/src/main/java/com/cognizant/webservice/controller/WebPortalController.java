package com.cognizant.webservice.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.webservice.feignclient.CalculateNetworthFeignClient;
import com.cognizant.webservice.model.Asset;
import com.cognizant.webservice.model.SellObjectMap;
import com.cognizant.webservice.model.UserData;
import com.cognizant.webservice.service.WebportalService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class WebPortalController {

	
	@Autowired
	UserData admin;

	private static List<String> revokedTokens = new ArrayList<String>();

	@Autowired
	WebportalService webportalService;
	

	@Autowired
	private CalculateNetworthFeignClient networthFeignClient;


	@GetMapping("/logout")
	public ModelAndView getLogout(HttpSession session) {
		if (session != null && (String) session.getAttribute("token") != null
				&& webportalService.isSessionValid((String) session.getAttribute("token"))) {
			revokedTokens.add((String) session.getAttribute("token"));
			System.out.println(session.getAttribute("token"));
			session.removeAttribute("token");
			System.out.println(session.getAttribute("token"));
			return new ModelAndView("login");
		}
		return new ModelAndView("Home");
	}


	@GetMapping("/")
	public ModelAndView getLogin(HttpSession session) {
		log.info("Starting getLogin");
		if (session != null && (String) session.getAttribute("token") != null	
				&& webportalService.isSessionValid((String) session.getAttribute("token"))			// &&    &
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending getLogin");
			return new ModelAndView("Home");
		}
		log.info("Ending getLogin");
		return new ModelAndView("login");
	}


	@PostMapping("/login")
	public <user> ModelAndView postLogin(HttpSession session, ModelMap model, @ModelAttribute UserData user,
			ModelMap warning) {
		log.info("Starting postLogin");
		log.info("Ending postLogin");
		return new ModelAndView(webportalService.postLogin(user, session, warning));
	}

	
	@GetMapping("/Home")
	public ModelAndView getHomePage(HttpSession session) {
		log.info("Starting getHomePage");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending getHomePage");
			return new ModelAndView("Home");
		}
		log.info("Ending getHomePage");
		return new ModelAndView("login");
	}
	


	@GetMapping("/viewfunds")
	public ModelAndView showViewFunds(HttpSession session, ModelMap model) {
		log.info("Starting showViewFunds");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showViewFunds");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("viewfunds");
		}
		log.info("Ending viewMutualFunds");  
		return new ModelAndView("login");
	}

	@GetMapping("/viewshares")
	public ModelAndView showViewShares(HttpSession session, ModelMap model) {
		log.info("Starting showViewShares");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showViewShares");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("viewshares");
		}
		log.info("Ending showViewShares");
		return new ModelAndView("login");
	}

	@GetMapping("/sellAssets")
	public ModelAndView showSupplyPage(HttpSession session, ModelMap model) {
		log.info("Starting showSellAssets");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showSellAssets");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("sellAssets");
		}
		log.info("Ending showSellAssets");
		return new ModelAndView("login");
	}


	@GetMapping("/viewportfolio")
	public ModelAndView showSupplyPages(HttpSession session, ModelMap model) {
		log.info("Starting showviewportfolio");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending showviewportfolio");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			List<Asset> asset = networthFeignClient.getAllAssets(token, i);
			model.put("asset", asset);
			return new ModelAndView("viewportfolio");
		}
		log.info("Ending showviewportfolio");
		return new ModelAndView("login");
	}


	@GetMapping("/viewNetworth")
	public ModelAndView showNetworth(HttpSession session, ModelMap model) {
		log.info("Starting viewNetworth");
		if (webportalService.isSessionValid((String) session.getAttribute("token"))
				&& !revokedTokens.contains((String) session.getAttribute("token"))) {
			log.info("Ending viewNetworth");
			String s = (String) session.getAttribute("memberId");
			int i = Integer.parseInt(s);
			String token = (String) session.getAttribute("token");
			model.put("networth", networthFeignClient.getAsset(token, i));
			return new ModelAndView("viewNetworth");
		}
		log.info("Ending viewNetworth");
		return new ModelAndView("login");
	}

	@PostMapping("/viewNetworth")
	public <user> ModelAndView sellAssetsSelected(HttpSession session, @RequestParam("selected") String[] name,
			@RequestParam("quantity") String[] count, ModelMap model) {
		log.info("Starting postLogin");
		log.info("Ending postLogin");
		String s = (String) session.getAttribute("memberId");
		int i = Integer.parseInt(s);
		String token = (String) session.getAttribute("token");
		List<Asset> list = networthFeignClient.getAllAssets(token, i);
		SellObjectMap sell = webportalService.sellShares(list, i, name, count);
		Map<String, String> assetMap = webportalService.convertToMap(name, count);
		// log.info(map.toString());
		model.put("networth", networthFeignClient.calculateBalancePostSellPerStock(token, sell));
		model.addAttribute("assetMap", assetMap);
		return new ModelAndView("viewNetworth");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	
	

	
	
	
	
	
}
