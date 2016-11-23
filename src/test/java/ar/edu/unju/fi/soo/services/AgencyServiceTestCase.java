package ar.edu.unju.fi.soo.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unju.fi.soo.model.Agency;
import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.PlanRegular;
import ar.edu.unju.fi.soo.model.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class AgencyServiceTestCase {
	private String clientName = "nombre test";
	private Agency agency;
	private Vehicle vehicle;

	protected void setUp() {
		agency = new Agency();
		vehicle = new Vehicle(240000d);
	}
	
	/**
	 * Test de buscar un plan por cliente
	 */
	public void testFindPlanByClient() {
		String expectedClientName = clientName;

		Client client = new Client(expectedClientName, "");
		Plan plan = new PlanRegular(vehicle, client, 80);

		List<Plan> plans = new ArrayList<Plan>();
		plans.add(plan);
		agency.setPlans(plans);

		Plan planFound = agency.findPlanByClientName(expectedClientName);

		assertEquals(planFound.getClient().getName(), expectedClientName);
		assertEquals(planFound, plan);
	}

}
