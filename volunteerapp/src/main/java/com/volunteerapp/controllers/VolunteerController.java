package com.volunteerapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VolunteerController {
	
	@RequestMapping(value="/volunteerLogin")
	public ModelAndView getVolunteerLogin(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided volunteer login method ... ");
		ModelAndView volunteerLogin = new ModelAndView("volunteerLogin");
		//volunteerLogin.addObject("message", message);
		//volunteerLogin.addObject("name", name);
		return volunteerLogin;
		
	}
	
	@RequestMapping(value="/volunteerProfile", method=RequestMethod.POST)
	public ModelAndView getVolunteerProfile(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided volunteer profile method ... ");
		ModelAndView volunteerProfile = new ModelAndView("volunteerProfile");
		//volunteerProfile.addObject("message", message);
		//volunteerProfile.addObject("name", name); 
		return volunteerProfile;
		
	}
	
	@RequestMapping(value="/deleteVolunteerProfile")
	public ModelAndView getDeleteVolunteerProfile(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided delete volunteer profile method ... ");
		ModelAndView volunteerLogin = new ModelAndView("volunteerLogin");
		//volunteerLogin.addObject("message", message);
		//volunteerLogin.addObject("name", name); 
		return volunteerLogin;
		
	}
	
	@RequestMapping(value="/volunteerRegistration")
	public ModelAndView getVolunteerRegistration(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided volunteer registration method ... ");
		ModelAndView volunteerRegistration = new ModelAndView("volunteerRegistration");
		//volunteerLogin.addObject("message", message);
		//volunteerLogin.addObject("name", name);
		return volunteerRegistration;
		
	}
}
