package ar.edu.unju.fi.soo.services;


import ar.edu.unju.fi.soo.model.Plan;

public interface AgencyService {

	Plan findPlanByClientName(String clientName);
	
}
