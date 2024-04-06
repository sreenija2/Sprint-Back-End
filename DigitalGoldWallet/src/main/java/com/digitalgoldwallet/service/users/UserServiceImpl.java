package com.digitalgoldwallet.service.users;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digitalgoldwallet.dao.user.UserRepository;
import com.digitalgoldwallet.exception.DuplicateUserIDException;
import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.PaymentsNotPresentException;
import com.digitalgoldwallet.exception.TransactionHistoryNotPresentException;
import com.digitalgoldwallet.exception.UserNotFoundException;
import com.digitalgoldwallet.model.Payments;
import com.digitalgoldwallet.model.PhysicalGoldTransactions;
import com.digitalgoldwallet.model.TransactionHistory;
import com.digitalgoldwallet.model.Users;
import com.digitalgoldwallet.model.VirtualGoldHoldings;

@Service
public class UserServiceImpl implements UsersService{
	
	@Autowired
	UserRepository UserDao;
 
	@Override
	public List<Users> getAllUsers() {
		return UserDao.findAll();
	}
	
	@Override
	public Users findUserByID(int userId) throws InvalidUserIDException, UserNotFoundException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		Optional<Users> user=UserDao.findById(userId);
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
	public void addUsers(Users u) throws InvalidUserIDException, DuplicateUserIDException {
		
		if(u.getUserId() <= 0) {
			throw new InvalidUserIDException("Id given is invalid!");
		}
		Optional<Users> user = UserDao.findById(u.getUserId());
		if(!user.isPresent()) {
			throw new DuplicateUserIDException("Given user is already present!!!");
		}
	    UserDao.saveAndFlush(u);
	    
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

	@Override
	public List<Users> getUsersByCity(String city) throws UserNotFoundException {
		List<Users> users = UserDao.findByAddressesCity(city);
		if(users.isEmpty()) {
			throw new UserNotFoundException("Users with the given city are not present!");
		}
		return users;
	}

	@Override
	public List<Users> getUsersByState(String state) throws UserNotFoundException {
		List<Users> users = UserDao.findByAddressesState(state);
		if(users.isEmpty()) {
			throw new UserNotFoundException("Users with the given city are not present!");
		}
		return users;
	}

	@Override
	public double getBalanceByUserId(int userId) throws InvalidUserIDException, UserNotFoundException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		Optional<Users> user = UserDao.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		double balance = user.get().getBalance();
		return balance;
	}

	@Override
	public double getTotalVirtualGoldHoldings(int userId) throws InvalidUserIDException, UserNotFoundException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		Optional<Users> user = UserDao.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		List<VirtualGoldHoldings> list = user.get().getVirtualgoldholdings();
		double total = 0;
		for(VirtualGoldHoldings holding : list) {
			total += holding.getQuantity();
		}
		return total;
	}

	@Override
	public double getTotalPhysicalGoldHoldings(int userId) throws InvalidUserIDException, UserNotFoundException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		Optional<Users> user = UserDao.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		List<PhysicalGoldTransactions> list = user.get().getPhysicalgoldtransactions();
		double total = 0;
		for(PhysicalGoldTransactions holding : list) {
			total += holding.getQuantity();
		}
		return total;
	}
	
	@Override
	public List<TransactionHistory> getTransactionHistory(int userId) throws InvalidUserIDException, UserNotFoundException, TransactionHistoryNotPresentException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		Optional<Users> user = UserDao.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		List<TransactionHistory> list = user.get().getTransactionhistory();
		if(list.isEmpty()) {
			throw new TransactionHistoryNotPresentException("User has no transaction history");
		}
		return list;
	}
	
	@Override
	public List<Payments> getPaymentsById(int userId) throws InvalidUserIDException, UserNotFoundException, PaymentsNotPresentException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		Optional<Users> user = UserDao.findById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		List<Payments> list = user.get().getPayments();
		if(list.isEmpty()) {
			throw new PaymentsNotPresentException("User has no payments");
		}
		return list;
	}
	
	@Transactional
	@Override
	public void updateUsersBalance(int userId, double amount) throws InvalidUserIDException, UserNotFoundException{
	
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid!");
		}
		
		Optional<Users> newUser = UserDao.findById(userId);
		if(!newUser.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		
		newUser.get().setBalance(amount);
	}

	@Transactional
	@Override
	public void updateUsersAddressId(int userId, int addressId) throws InvalidUserIDException, UserNotFoundException{
		
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid!");
		}
		
		Optional<Users> newUser = UserDao.findById(userId);
		if(!newUser.isPresent()) {
			throw new UserNotFoundException("User with this id is not present");
		}
		
		newUser.get().getAddress().setAddressId(addressId);
		
	}
}
