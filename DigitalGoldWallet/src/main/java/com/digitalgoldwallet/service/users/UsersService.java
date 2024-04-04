package com.digitalgoldwallet.service.users;

import java.util.List;

import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.UserNotFoundException;
import com.digitalgoldwallet.model.Users;

public interface UsersService {
	
	public List<Users> GetAllUsers();
	public Users findUserByID(int userId) throws InvalidUserIDException, UserNotFoundException;
	public Users findByName(String name);
	public Users addUsers(Users u) throws InvalidUserIDException ;
	public Users updateUser(Users userId) throws InvalidUserIDException;

}
