package ar.edu.unju.fi.soo.services;

import static org.junit.Assert.assertNotNull;


import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class NetClientGetTestCase {
	@Inject
	private NetClientGet netClientGet;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetCurrencyValue() {
		// get currency value
		String value = netClientGet.getCurrencyValue();
	
		// ... value cant be null
		assertNotNull(value);
	}
}
