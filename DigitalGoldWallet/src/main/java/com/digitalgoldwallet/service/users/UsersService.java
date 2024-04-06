package com.digitalgoldwallet.service.users;

import java.util.List;

import com.digitalgoldwallet.exception.DuplicateUserIDException;
import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.PaymentsNotPresentException;
import com.digitalgoldwallet.exception.TransactionHistoryNotPresentException;
import com.digitalgoldwallet.exception.UserNotFoundException;
import com.digitalgoldwallet.model.Payments;
import com.digitalgoldwallet.model.TransactionHistory;
import com.digitalgoldwallet.model.Users;
import com.digitalgoldwallet.model.VirtualGoldHoldings;

public interface UsersService {
	
	public List<Users> getAllUsers();
	public Users findUserByID(int userId) throws InvalidUserIDException, UserNotFoundException;
	public Users findByName(String name);
	public void addUsers(Users u) throws InvalidUserIDException, DuplicateUserIDException ;
	public Users updateUser(Users userId) throws InvalidUserIDException;
	public List<Users> getUsersByCity(String city) throws UserNotFoundException;
	public List<Users> getUsersByState(String state) throws UserNotFoundException;
	public double getBalanceByUserId(int userId) throws InvalidUserIDException, UserNotFoundException;
	public double getTotalVirtualGoldHoldings(int userId) throws InvalidUserIDException, UserNotFoundException;
	public double getTotalPhysicalGoldHoldings(int userId) throws InvalidUserIDException, UserNotFoundException;
	public List<TransactionHistory> getTransactionHistory(int userId) throws InvalidUserIDException, UserNotFoundException, TransactionHistoryNotPresentException;
	public List<Payments> getPaymentsById(int userId) throws InvalidUserIDException, UserNotFoundException, PaymentsNotPresentException;
	public void updateUsersBalance(int userId, double amount) throws InvalidUserIDException, UserNotFoundException;
	public void updateUsersAddressId(int userId, int addressId) throws InvalidUserIDException, UserNotFoundException;
}
