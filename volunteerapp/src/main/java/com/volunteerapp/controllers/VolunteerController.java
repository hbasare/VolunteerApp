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
		ModelAndView search = new ModelAndView("volunteerLogin");
		//search.addObject("message", message);
		//mv.addObject("name", name);
		return search;
		
	}
	
	@RequestMapping(value="/volunteerProfile", method=RequestMethod.POST)
	public ModelAndView getVolunteerProfile(
			@RequestParam(value = "username", required = false, defaultValue = "World") String username) {
		
		System.out.println("insided volunteer profile method ... ");
		ModelAndView search = new ModelAndView("volunteerProfile");
		//mv.addObject("message", message);
		//mv.addObject("name", name); 
		return search;
		
	}
}
