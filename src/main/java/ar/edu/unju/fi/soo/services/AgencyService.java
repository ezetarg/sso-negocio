package ar.edu.unju.fi.soo.services;

import java.util.List;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.Vehicle;

public interface AgencyService {

	List<Plan> findPlanByClientName(String clientName);

	void savePlan(Plan plan);

	void saveClient(Client client);

	List<Vehicle> listVehicles();

	List<Client> listClients();
}
