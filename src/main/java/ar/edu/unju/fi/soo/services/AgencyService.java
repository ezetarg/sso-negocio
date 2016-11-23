package ar.edu.unju.fi.soo.services;

import java.util.List;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Plan;

public interface AgencyService {

	List<Plan> findPlanByClientName(String clientName);

	void savePlan(Plan plan);

	void saveClient(Client client);
}
