package com.volunteerapp.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.volunteerapp.model.Client;
import com.volunteerapp.model.Volunteer;

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
	public ModelAndView getVolunteerProfile(@ModelAttribute("volunteer") Volunteer volunteer, HttpServletRequest request) {
		
		System.out.println("insided volunteer profile method ... ");
		// process profile submission.
		request.getSession().setAttribute("clientVolunteer", volunteer);
		System.out.println("added to session ...");
		
		return new ModelAndView("volunteerProfile", "volunteer", volunteer);		
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
	public ModelAndView getVolunteerRegistration(@ModelAttribute("volunteer") Volunteer volunteer, Model model, HttpServletRequest request) {
		System.out.println("insided volunteer registration method ... ");
		
		if (volunteer.getFirstName().length() == 0 || volunteer.getLastName().length() == 0 ||
				volunteer.getEmail().length() == 0 || volunteer.getPassword().length() == 0 || 
						volunteer.getReEnterPassword().length() == 0 ) {
			return new ModelAndView("volunteerRegistration");
		} else {
			//process registration
			request.getSession().setAttribute("volunteerProfile", volunteer);
			System.out.println("processing volunteer registraiton ...");
			return new ModelAndView("volunteerProfile");
		}		
	}
	
	@RequestMapping(value="/displayVolunteerRegistration")
	public ModelAndView displayClientRegistration( ) {
		System.out.println("insided display Volunteer Registration ... ");
		return new ModelAndView("volunteerRegistration", "volunteer", new Volunteer());		
	}
}
