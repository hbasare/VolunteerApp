package com.volunteerapp.services;

import com.volunteerapp.model.Search;
import com.volunteerapp.model.SearchResults;
import com.volunteerapp.model.Volunteer;

public class SearchService {

	public SearchResults executeSearch(Search searchParameters) {
		return buildSearchResuts(searchParameters);
	}
	
	private SearchResults buildSearchResuts (Search searchParameters) {
		
		Volunteer volunteer1 = new Volunteer();
		Volunteer volunteer2 = new Volunteer();
		Volunteer volunteer3 = new Volunteer();
		Volunteer volunteer4 = new Volunteer();
		Volunteer volunteer5 = new Volunteer();
		
		volunteer1.setFirstName("Doga");
		volunteer1.setLastName("Tav");
		volunteer1.setEmail("doga@gmail.com");
		volunteer1.setPhoneNumber("506-123-4561");
		volunteer1.setCity(searchParameters.getCity());
		
		volunteer2.setFirstName("Nicole");
		volunteer2.setLastName("McGee");
		volunteer2.setEmail("nicole@gmail.com");
		volunteer2.setPhoneNumber("506-456-4562");
		volunteer2.setCity(searchParameters.getCity());
		
		volunteer3.setFirstName("Shubhra");
		volunteer3.setLastName("Singhal");
		volunteer3.setEmail("shubhra@gmail.com");
		volunteer3.setPhoneNumber("506-456-4563");
		volunteer3.setCity(searchParameters.getCity());
		
		volunteer4.setFirstName("Prabina");
		volunteer4.setLastName("Dhakal");
		volunteer4.setEmail("prabina@gmail.com");
		volunteer4.setPhoneNumber("506-456-4564");
		volunteer4.setCity(searchParameters.getCity());
		
		volunteer5.setFirstName("Henry");
		volunteer5.setLastName("Bediako-Asare");
		volunteer5.setEmail("henry@gmail.com");
		volunteer5.setPhoneNumber("506-456-4565");
		volunteer5.setCity(searchParameters.getCity());
		
		SearchResults results = new SearchResults();
		results.getVolunteers().add(volunteer1);
		results.getVolunteers().add(volunteer2);
		results.getVolunteers().add(volunteer3);
		results.getVolunteers().add(volunteer4);
		results.getVolunteers().add(volunteer5);
		
		return results;
	}
}
