package ar.edu.unju.fi.soo.services.impl;

import java.util.ArrayList;
import java.util.List;


import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.services.AgencyService;


@Named
@Transactional
public class AgencyServiceImpl implements AgencyService {
	
	public List<Plan> plans = new ArrayList<Plan>();

	@Override
	public Plan findPlanByClientName(String clientName) {
		for(Plan plan : plans) {
			if (clientName.equalsIgnoreCase(plan.getClient().getName())) {
				return plan;
			}
		}
		return null;
	}

}
