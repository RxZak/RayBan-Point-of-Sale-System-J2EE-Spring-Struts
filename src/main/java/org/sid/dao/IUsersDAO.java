package org.sid.dao;

import java.util.List;

import org.sid.entities.Users;

public interface IUsersDAO {
	public boolean addUser(Users user);
	public Users getUserByUsername(String username);
	public Users getUserByUsernameAndPassword(String username,String password);
	public boolean updateUser(Users user);
	public List<Users> listsUsers();

}
