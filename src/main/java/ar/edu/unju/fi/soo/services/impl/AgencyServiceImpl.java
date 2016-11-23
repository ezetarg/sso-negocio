package ar.edu.unju.fi.soo.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.dao.ClientDAO;
import ar.edu.unju.fi.soo.model.dao.PlanDAO;
import ar.edu.unju.fi.soo.services.AgencyService;

@Named
@Transactional
public class AgencyServiceImpl implements AgencyService {
	@Inject
	private ClientDAO clientDAO;
	@Inject
	private PlanDAO planDAO;

	@Override
	public List<Plan> findPlanByClientName(String clientName) {
		return planDAO.findAllByClientName(clientName);
	}

	@Override
	public void savePlan(Plan plan) {
		planDAO.save(plan);
	}

	@Override
	public void saveClient(Client client) {
		clientDAO.save(client);
	}
}
