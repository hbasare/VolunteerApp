package com.volunteerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

	@RequestMapping(value="/search", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView getSearch(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided search method ... ");
		ModelAndView search = new ModelAndView("search");
		//mv.addObject("message", message);
		//mv.addObject("name", name); 
		return search;
		
	}
	
	@RequestMapping(value="/clientLogin")
	public ModelAndView getClientLogin(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided client Login method ... ");
		ModelAndView clientLogin = new ModelAndView("clientLogin");
		//search.addObject("message", message);
		//mv.addObject("name", name);
		return clientLogin;
		
	}
	
	@RequestMapping(value="/clientLogout")
	public ModelAndView getClientLogout(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided client Logout method ... ");
		ModelAndView clientLogin = new ModelAndView("clientLogin");
		//search.addObject("message", message);
		//mv.addObject("name", name);
		return clientLogin;
		
	}
	
	@RequestMapping(value="/clientRegister")
	public ModelAndView getClientRegister(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided client Register method ... ");
		ModelAndView search = new ModelAndView("clientRegistration");
		//search.addObject("message", message);
		//mv.addObject("name", name);
		return search;
		
	}
	
	@RequestMapping(value="/editClientProfile")
	public ModelAndView getEditClientProfile(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided edit client profile method ... ");
		ModelAndView clientProfile = new ModelAndView("clientProfile");
		//search.addObject("message", message);
		//mv.addObject("name", name);
		return clientProfile;
		
	}
}
