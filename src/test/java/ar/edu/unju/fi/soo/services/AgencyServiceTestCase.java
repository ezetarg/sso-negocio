package ar.edu.unju.fi.soo.services;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unju.fi.soo.model.Client;
import ar.edu.unju.fi.soo.model.Plan;
import ar.edu.unju.fi.soo.model.PlanRegular;
import ar.edu.unju.fi.soo.model.Vehicle;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class AgencyServiceTestCase {
	
	@Autowired
	private AgencyService agencyService;
	private String clientName = "nombre test";
	private Vehicle vehicle;
	private Client client;
	private List<Plan> plans;
	private Client clientTest;
	private Vehicle vehicleTest;

	protected void setUp() {
		//vehicle = new Vehicle(240000d);

	}

	@Test
	public void emptyTest() {
		assert true;
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
	
	
	public void testCreatePlan7030(){
		plans = agencyService.findPlanByClientDNI(null, client.getDni());
		assertNotNull(plans);
	}
	
	public void testCreateClient(){
		clientTest = new Client();
		clientTest.setName("nameTestClient");
		clientTest.setDni("dniTestClient");
		agencyService.saveClient(clientTest);
		String name = agencyService.getClientByName(clientTest.getName()).getName();
		assertEquals(clientTest.getName(), name);
	}
	
	@Test
	public void TestCreateVehicle(){
		vehicleTest = new Vehicle();
		vehicleTest.setValue(542478d);
		vehicleTest.setCode("codeTestVehicle");		
		
		agencyService.saveVehicle(vehicleTest);
		
		String code = agencyService.getVehicleByCode(vehicleTest.getCode()).getCode();
		assertEquals(vehicleTest.getCode(), code);
	}
	
	@Test
	public void TestPayNextFee(){
		clientTest = new Client();
		clientTest.setName("nameTestClient");
		clientTest.setDni("dniTestClient");
		agencyService.saveClient(clientTest); 
		
		vehicleTest = new Vehicle();
		vehicleTest.setValue(542478d);
		vehicleTest.setCode("codeTestVehicle");			
		agencyService.saveVehicle(vehicleTest);
		

		agencyService.createPlan(1l, 1l, 80, "plan7030");
		
		agencyService.payNextFee(1l);
		
		assertTrue(agencyService.getPlanById(1l).getFees().get(0).isPaid());
	}
	
	

}
