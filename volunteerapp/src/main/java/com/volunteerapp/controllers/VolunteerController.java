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
import com.volunteerapp.model.ClientLogIn;
import com.volunteerapp.model.Search;
import com.volunteerapp.model.Volunteer;
import com.volunteerapp.model.VolunteerLogIn;

@Controller
public class VolunteerController {
	
	@RequestMapping(value="/volunteerLogin")
	public ModelAndView getVolunteerLogin(@ModelAttribute("volunteerLogin") VolunteerLogIn volunteerLogin, HttpServletRequest request) {
		
		System.out.println("insided volunteer login method ... ");
		if (volunteerLogin.getUsername().equals("b@gmail.com") && volunteerLogin.getPassword().equals("123")) {
			//get volunteer profile
			System.out.println("getting volunteer details for profile page ... ");
			Volunteer volunteer = new Volunteer();
			volunteer.setFirstName("Doga");
			volunteer.setLastName("Tav");
			volunteer.setEmail("b@gmail.com");
			return new ModelAndView("volunteerProfile", "volunteer", volunteer);
		} else {
			return new ModelAndView("volunteerLogin", "volunteerLogin", volunteerLogin);
		}	
		
		//ModelAndView volunteerLogin = new ModelAndView("volunteerLogin");
		//volunteerLogin.addObject("message", message);
		//volunteerLogin.addObject("name", name);
		//return volunteerLogin;
		
	}
	
	@RequestMapping(value="/displayVolunteerLogin")
	public ModelAndView displayVolunteerLogin( ) {
		
		System.out.println("inside display Volunteer Login method ... ");
		//search.addObject("message", message);
		//mv.addObject("name", name);
		return new ModelAndView("volunteerLogin", "volunteerLogin", new VolunteerLogIn());
		
	}
	
	@RequestMapping(value="/volunteerLogout")
	public ModelAndView getVolunteerLogout(HttpServletRequest request) {		
		System.out.println("insided volunteer Logout method ... ");
		request.getSession().setAttribute("volunteerProfile", null);
		return new ModelAndView("volunteerLogin", "volunteerLogin", new VolunteerLogIn());		
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
	public ModelAndView deleteVolunteerProfile(HttpServletRequest request) {
		System.out.println("insided delete volunteer profile method ... ");
		Volunteer volunteer = (Volunteer) request.getSession().getAttribute("volunteerProfile");
		// process deletion.
		request.getSession().setAttribute("clientVolunteer", null);
		return new ModelAndView("volunteerLogin", "volunteerLogin", new VolunteerLogIn());		
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
