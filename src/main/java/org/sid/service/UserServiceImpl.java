package org.sid.service;

import java.util.List;

import org.sid.dao.IUsersDAO;
import org.sid.entities.Users;

public class UserServiceImpl implements IUserService{
	// DAO
	private IUsersDAO usersDAO;
	
	// Getter and Setter
	public IUsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(IUsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	// Implementation
	@Override
	public boolean addUser(Users user) {
		return usersDAO.addUser(user);
	}

	@Override
	public Users getUserByUsername(String username) {
		return usersDAO.getUserByUsername(username);
	}

	@Override
	public Users getUserByUsernameAndPassword(String username, String password) {
		return usersDAO.getUserByUsernameAndPassword(username, password);
	}

	@Override
	public boolean updateUser(Users user) {
		return usersDAO.updateUser(user);
	}

	@Override
	public List<Users> listsUsers() {
		return usersDAO.listsUsers();
	}

}
