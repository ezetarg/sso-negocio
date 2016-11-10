package ar.edu.unju.fi.soo.services;

import java.util.List;

import ar.edu.unju.fi.soo.model.User;

public interface SecurityService {

	List<User> listUsers();

	User createUser(String username, String password, String name, String lastname);

	void saveOrUpdateUser(User user);

	void deleteUser(User user);

	User getUser(Long id);

	User login(String username, String password);
}
