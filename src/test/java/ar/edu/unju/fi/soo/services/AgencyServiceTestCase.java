package ar.edu.unju.fi.soo.services;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.PlanRegular;
import ar.edu.unju.fi.soo.model.Vehicle;
import ar.edu.unju.fi.soo.services.impl.AgencyServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class AgencyServiceTestCase {
	
	@Autowired
	private AgencyServiceImpl agencyService;
	private String clientName = "nombre test";
	private Vehicle vehicle;

	protected void setUp() {
		vehicle = new Vehicle(240000d);
	}

	/**
	 * Test de buscar un plan por cliente
	 */
	public void testFindPlanByClient() {
		String expectedClientName = clientName;

		// Se guarda el cliente
		Client client = new Client(expectedClientName, "");
		agencyService.saveClient(client);

		// Se guarda el plan
		Plan plan = new PlanRegular(vehicle, client, 80);
		agencyService.savePlan(plan);

		List<Plan> plans = agencyService.findPlanByClientName(expectedClientName);
		Plan planFound = plans.get(0);

		assertEquals(planFound.getClient().getName(), expectedClientName);
		assertEquals(planFound, plan);
	}

}
