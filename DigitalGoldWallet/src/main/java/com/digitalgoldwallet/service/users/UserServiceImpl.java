package com.digitalgoldwallet.service.users;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digitalgoldwallet.dao.user.UserRepository;
import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.UserNotFoundException;
import com.digitalgoldwallet.model.Users;

@Service
public class UserServiceImpl implements UsersService{
	
	@Autowired
	UserRepository UserDao;
 
	@Override
	public List<Users> GetAllUsers() {
		// TODO Auto-generated method stub
		return UserDao.findAll();
	}
	
	@Override
	public Users findUserByID(int userId) throws InvalidUserIDException, UserNotFoundException {
		// TODO Auto-generated method stub
		Optional<Users> user=UserDao.findById(userId);
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		
		return user.get();
	}
	@Override
	public Users findByName(String name) {
		// TODO Auto-generated method stub
		Optional<Users> username=UserDao.findByName(name);
		return username.get();
	
	}
	@Transactional
	@Override
	public Users addUsers(Users u) throws InvalidUserIDException {
		
		if(u.getUserId() <= 0) {
			throw new InvalidUserIDException("Id given is invalid!");
		}
	    return UserDao.saveAndFlush(u);
	    
	}
	@Transactional
	@Override
	public Users updateUser(Users user) throws InvalidUserIDException{
		
		if(user.getUserId() <= 0) {
			throw new InvalidUserIDException("The id given is invalid!");
		}
		
		Optional<Users> address=UserDao.findById(user.getUserId());
		Users user1 = address.get();
		user1.setEmail(user.getEmail());
		user1.setName(user.getName());
		user1.setBalance(user.getBalance());
		user1.setCreatedAt(user.getCreatedAt());
		user1.setAddress(user.getAddress());
		return user1;
		
	}
}
