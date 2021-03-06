package ar.edu.unju.fi.soo.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Fee;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.Plan7030;
import ar.edu.unju.fi.soo.model.PlanRegular;
import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.model.dao.ClientDAO;
import ar.edu.unju.fi.soo.model.dao.FeeDAO;
import ar.edu.unju.fi.soo.model.dao.PlanDAO;
import ar.edu.unju.fi.soo.model.dao.VehicleDAO;
import ar.edu.unju.fi.soo.services.AgencyService;

@Named
@Transactional(readOnly = true)
public class AgencyServiceImpl implements AgencyService {
	@Inject
	private ClientDAO clientDAO;
	@Inject
	private FeeDAO feeDAO;
	@Inject
	private PlanDAO planDAO;
	@Inject
	private VehicleDAO vehicleDAO;

	@Override
	public List<Plan> findPlanByClientName(String clientName) {
		return planDAO.findAllByClientName(clientName);
	}

	@Override
	public Fee getNextUnpaidFee(Long planId) {
		return feeDAO.getNextUnpaidFee(planId);
	}

	@Override
	@Transactional
	public void payNextFee(Long planId) {
		Fee fee = getNextUnpaidFee(planId);
		fee.pay();
		feeDAO.save(fee);
	}

	@Override
	@Transactional
	public void savePlan(Plan plan) {
		planDAO.save(plan);
	}

	@Override
	@Transactional
	public void saveClient(Client client) {
		clientDAO.save(client);
	}

	@Override
	public List<Vehicle> listVehicles() {
		return vehicleDAO.list();
	}

	@Override
	public List<Client> listClients() {
		return clientDAO.list();
	}

	@Override
	public List<Plan> findPlanByClientDNI(String planType, String clientField) {
		return planDAO.findAllByClientDNI(planType, clientField);
	}

	@Transactional
	@Override
	public void deleteClient(Client client) {
		clientDAO.delete(client);
	}

	@Override
	public Client getClientById(Long id) {
		return clientDAO.get(id);
	}

	@Override
	public Vehicle getVehicleById(Long id) {
		return vehicleDAO.get(id);
	}

	@Transactional
	@Override
	public void saveVehicle(Vehicle vehicle) {
		vehicleDAO.save(vehicle);
	}

	@Transactional
	@Override
	public void deleteVehicle(Vehicle vehicle) {
		vehicleDAO.delete(vehicle);
	}

	@Transactional
	@Override
	public void createPlan(Long vehicleId, Long clientId, int feesAmount, String planType) {
		Plan plan = null;
		Vehicle vehicle = vehicleDAO.get(vehicleId);
		Client client = clientDAO.get(clientId);

		if (planType == "planRegular") {
			plan = new PlanRegular(vehicle, client, feesAmount);
		} else {
			plan = new Plan7030(vehicle, client, feesAmount);
		}

		System.out.println("Guardando nuevo plan " + planType);
		plan.setCreateDate(new Date());
		planDAO.save(plan);
	}

	@Override
	public Plan getPlanById(Long id) {
		return planDAO.get(id);
	}

	@Override
	public Client getClientByName(String name) {
		return clientDAO.findByName(name);
	}

	@Override
	public Vehicle getVehicleByCode(String code) {
		return vehicleDAO.findByCode(code);
	}
}
