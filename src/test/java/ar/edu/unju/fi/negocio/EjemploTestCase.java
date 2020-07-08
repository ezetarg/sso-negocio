package ar.edu.unju.fi.negocio;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test Ejemplo para verificar la inyección de dependencias
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class EjemploTestCase {

	@Inject
	private Ejemplo ejemplo;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		ejemplo = null;
	}

	@Test
	public void testSpring() {
		assertNotNull(ejemplo);
	}

}
