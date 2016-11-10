package ar.edu.unju.fi.soo.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.soo.model.User;
import ar.edu.unju.fi.soo.model.dao.UserDAO;
import ar.edu.unju.fi.soo.services.SecurityService;

@Named
@Transactional
public class SecurityServiceImpl implements SecurityService {

	@Inject
	private UserDAO userDAO;

	@Override
	public List<User> listUsers() {
		return userDAO.list();
	}

	public User createUser(String username, String password, String name, String lastname) {
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setLastname(lastname);
		user.setPassword(password);
		userDAO.save(user);
		return user;
	}

	public void saveOrUpdateUser(User user) {
		userDAO.save(user);
	}

	public void deleteUser(User user) {
		userDAO.delete(user);
	}

	@Override
	public User getUser(Long id) {
		return userDAO.get(id);
	}

	@Override
	public User login(String username, String password) {
		return userDAO.login(username, password);
	}
}
