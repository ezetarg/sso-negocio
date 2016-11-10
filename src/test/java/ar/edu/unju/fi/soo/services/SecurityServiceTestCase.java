package ar.edu.unju.fi.soo.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.unju.fi.soo.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml" })
public class SecurityServiceTestCase {
	@Inject
	private SecurityService securityService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListOfUsers() {
		assertNotNull(securityService.listUsers());
	}

	@Test
	public void testCreateLoginAndDelete() {
		String username = "emontes";
		String password = "password";
		String name = "Ezequiel " + Math.random();
		String lastname = "Montes " + Math.random();

		// Create an user
		User user = securityService.createUser(username, password, name, lastname);
		// ...and it have an ID now
		assertNotNull(user.getId());

		// Find the user by name
		User userFound = securityService.login(username, password);
		// ... and the user exists.
		assertNotNull(userFound);

		// Delete the user found
		securityService.deleteUser(userFound);

		// Find the user by name again
		User userNotFound = securityService.getUser(user.getId());
		// ... and the user doesn't exist.
		assertNull(userNotFound);
	}

	@Test
	public void testSaveAndList() {
		String username = "emontes";
		String password = "password";
		String name = "Ezequiel " + Math.random();
		String lastname = "Montes " + Math.random();

		// List all the users
		List<User> users = securityService.listUsers();
		// and the returned list must be not null
		assertNotNull(users);

		// Save a new user.
		User user = new User();
		user.setLastname(lastname);
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		securityService.saveOrUpdateUser(user);
		// and list all the users again
		List<User> users2 = securityService.listUsers();
		// and the returned list must be not null
		assertNotNull(users2);
		// and the new list have an extra result.
		assertTrue(users2.size() == users.size() + 1);
	}

}
