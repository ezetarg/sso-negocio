package ar.edu.unju.fi.soo.services;

import java.util.List;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.Vehicle;

public interface AgencyService {

	List<Plan> findPlanByClientName(String clientName);

	Fee getNextUnpaidFee(Long planId);

	void payNextFee(Long planId);

	void savePlan(Plan plan);

	void saveClient(Client client);

	List<Vehicle> listVehicles();

	List<Client> listClients();

	List<Plan> findPlanByClientDNI(String planType, String clientField);

	void deleteClient(Client client);

	Client getClientById(Long id);

	Vehicle getVehicleById(Long id);

	void saveVehicle(Vehicle vehicle);

	Plan getPlanById(Long id);

}
