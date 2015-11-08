package com.volunteerapp.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.volunteerapp.model.Client;

@Controller
public class ClientController {

	@RequestMapping(value="/search")
	public ModelAndView getSearch( ) {
		System.out.println("insided search method ... ");
		//mv.addObject("message", message);
		//mv.addObject("name", name); 
		return new ModelAndView("search");
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
	public ModelAndView getClientLogout(HttpServletRequest request) {		
		System.out.println("insided client Logout method ... ");
		request.getSession().setAttribute("clientProfile", null);
		return new ModelAndView("clientLogin");		
	}
	
	@RequestMapping(value="/clientRegistration")
	public ModelAndView getClientRegister(@ModelAttribute("client") Client client, Model model, HttpServletRequest request) {
		System.out.println("insided client Register method ... ");
		/*System.out.println("client first name : " + client.getFirstName());
		System.out.println("client last name : " + client.getLastName());
		System.out.println("client email : " + client.getEmail());
		System.out.println("client pasword : " + client.getPassword());
		System.out.println("client repasword : " + client.getReEnterPassword()); 
		*/		
		if (client.getFirstName().length() == 0 || client.getLastName().length() == 0 ||
				client.getEmail().length() == 0 || client.getPassword().length() == 0 || 
				client.getReEnterPassword().length() == 0 ) {
			return new ModelAndView("clientRegistration");
		} else {
			//process registration
			request.getSession().setAttribute("clientProfile", client);
			System.out.println("processing client registraiton ...");
			return new ModelAndView("search");
		}
		
		
	}
	
	@RequestMapping(value="/displayClientRegistration")
	public ModelAndView displayClientRegistration( ) {
		System.out.println("insided display Client Registration ... ");
		return new ModelAndView("clientRegistration", "client", new Client());		
	}
	
	@RequestMapping(value="/editClientProfile")
	public ModelAndView getEditClientProfile(@ModelAttribute("client") Client client, HttpServletRequest request) {
		System.out.println("insided edit client profile method ... ");
		
		System.out.println("client first name : " + client.getFirstName());
		System.out.println("client last name : " + client.getLastName());
		System.out.println("client email : " + client.getEmail());
		System.out.println("client pasword : " + client.getPassword());
		System.out.println("client repasword : " + client.getReEnterPassword()); 
		
		request.getSession().setAttribute("clientProfile", client);
		System.out.println("added to session ...");
		
		return new ModelAndView("clientProfile", "client", client);
	}
	
	@RequestMapping(value="/displayEditClientProfile")
	public ModelAndView displayEditClientProfile(HttpServletRequest request) {
		System.out.println("insided display Edit Client Profile method ... ");
		Client client = (Client) request.getSession().getAttribute("clientProfile");
		
		/*System.out.println("client first name : " + client.getFirstName());
		System.out.println("client last name : " + client.getLastName());
		System.out.println("client email : " + client.getEmail());
		System.out.println("client pasword : " + client.getPassword());
		System.out.println("client repasword : " + client.getReEnterPassword()); */
		
		return new ModelAndView("clientProfile", "client", client);
	}
}
