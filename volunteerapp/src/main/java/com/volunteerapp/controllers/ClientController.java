package com.volunteerapp.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.volunteerapp.model.Client;
import com.volunteerapp.model.ClientLogIn;
import com.volunteerapp.model.Search;
import com.volunteerapp.model.SearchResults;
import com.volunteerapp.services.SearchService;

@Controller
public class ClientController {

	@RequestMapping(value="/search")
	public ModelAndView getSearch(@ModelAttribute("search") Search searchParameters, HttpServletRequest request) {
		System.out.println("insided search method ... ");
		if (searchParameters.getCity().length() != 0 || searchParameters.getGender().length() != 0 ||
				searchParameters.getLang().length() != 0 || searchParameters.getProvince().length() != 0 ||
						searchParameters.getSkillSet().length() != 0) {
			
			System.out.println("executing search ... ");
			SearchService service = new SearchService();
			SearchResults results  = service.executeSearch(searchParameters);
			ModelAndView searchModelView = new ModelAndView("search");
			searchModelView.addObject("searchResults", results.getVolunteers());
			searchModelView.addObject("search", searchParameters);
			return searchModelView;
			//return new ModelAndView("search", "search", search);
		} else {
			return new ModelAndView("search", "search", searchParameters);
		}
	}
	
	@RequestMapping(value="/clientLogin")
	public ModelAndView getClientLogin(@ModelAttribute("clientLogin") ClientLogIn clientLogin, HttpServletRequest request) {
		
		System.out.println("insided client Login method ... ");
		if (clientLogin.getUsername().equals("a@gmail.com") && clientLogin.getPassword().equals("123")) {
			Client client = new Client ();
			client.setFirstName("Nicole");
			client.setLastName("McNeil");
			client.setEmail("a@gmail.come");
			request.getSession().setAttribute("clientProfile", client);
			return new ModelAndView("search", "search", new Search());
		} else {
			return new ModelAndView("clientLogin");
		}		
	}
	
	@RequestMapping(value="/displayClientLogin")
	public ModelAndView displayClientLogin( ) {
		
		System.out.println("insided display client Login method ... ");
		//search.addObject("message", message);
		//mv.addObject("name", name);
		return new ModelAndView("clientLogin", "clientLogin", new ClientLogIn());
		
	}
	
	@RequestMapping(value="/clientLogout")
	public ModelAndView getClientLogout(HttpServletRequest request) {		
		System.out.println("insided client Logout method ... ");
		request.getSession().setAttribute("clientProfile", null);
		return new ModelAndView("clientLogin", "clientLogin", new ClientLogIn());		
	}
	
	@RequestMapping(value="/deleteClientProfile")
	public ModelAndView deleteClientProfile(HttpServletRequest request) {
		System.out.println("insided delete client profile method ... ");
		//Client client = (Client) request.getSession().getAttribute("clientProfile");
		// process deletion.
		request.getSession().setAttribute("clientProfile", null);
		return new ModelAndView("clientLogin", "clientLogin", new ClientLogIn());		
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
			return new ModelAndView("search", "search", new Search());
		}
	}
	
	@RequestMapping(value="/displaySearch")
	public ModelAndView displaySearch( ) {
		System.out.println("insided display search method ... ");
		//mv.addObject("message", message);
		//mv.addObject("name", name); 
		return new ModelAndView("search", "search", new Search());
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
