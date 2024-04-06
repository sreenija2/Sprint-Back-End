package com.digitalgoldwallet.controller.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalgoldwallet.controller.successresponse.SuccessResponse;
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
import com.digitalgoldwallet.service.users.UsersService;

@RestController
@Validated
@RequestMapping(value="/api/v1/users")
public class UsersController {
	
	@Autowired
	UsersService Userserv;
	
	@GetMapping
	List<Users> getAllUsers(){
		
		System.out.println("get the users");
		List<Users> users = Userserv.getAllUsers();
		return users;
		
	}
	
	@GetMapping(path="{user_id}")
	ResponseEntity<Users> findUserByID(@PathVariable("user_id") int user_id) throws UserNotFoundException, InvalidUserIDException {
		
		if(user_id <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		Users user=Userserv.findUserByID(user_id);
		if(user == null) {
			throw new UserNotFoundException("User with this id is not present");
		}
		return new ResponseEntity<Users>(user,HttpStatus.OK);
	}
	
	@GetMapping(path="/name/{user_name}")
	ResponseEntity< Users >findByName(@PathVariable("user_name") String user_name) {
		Users name=Userserv.findByName(user_name);
		//System.out.println(name);
		return new ResponseEntity<Users>(name,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	ResponseEntity<SuccessResponse> addUsers(@Valid @RequestBody Users users) throws InvalidUserIDException, DuplicateUserIDException{
		if(users.getUserId() <= 0) {
			throw new InvalidUserIDException("Id given is invalid");
		}
		Userserv.addUsers(users);
		SuccessResponse response = new SuccessResponse("Users details added successfully", LocalDateTime.now());
		ResponseEntity<SuccessResponse> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/update/{userId}")
	ResponseEntity<Users> updateUser(@RequestBody Users user) throws InvalidUserIDException{
		if(user.getUserId() <= 0) {
			throw new InvalidUserIDException("The id given is invalid!");
		}
		Users address=Userserv.updateUser(user);
		return new ResponseEntity<Users>(address,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="/by_city/{city}")
	ResponseEntity<List<Users>> getUsersByCity(@PathVariable("city") String city) throws UserNotFoundException{
		List<Users> users = Userserv.getUsersByCity(city);
		if(users.isEmpty()) {
			throw new UserNotFoundException("Users with the given city are not present!");
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
	@GetMapping(value="/by_state/{state}")
	ResponseEntity<List<Users>> getUsersByState(@PathVariable("state") String state) throws UserNotFoundException{
		List<Users> users = Userserv.getUsersByState(state);
		if(users.isEmpty()) {
			throw new UserNotFoundException("Users with the given city are not present!");
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}
	
	@GetMapping("/check_balance/{user_id}")
	ResponseEntity<Double> getBalanceByUserId(@PathVariable("user_id") int userId) throws InvalidUserIDException, UserNotFoundException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		double balance = Userserv.getBalanceByUserId(userId);
		return new ResponseEntity<>(balance, HttpStatus.OK);
	}
	
	@GetMapping("/{user_id}/virtual_gold_holdings")
	public double getTotalVirtualGoldHoldings(@PathVariable("user_id") int userId) throws InvalidUserIDException, UserNotFoundException {
		
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		return Userserv.getTotalVirtualGoldHoldings(userId);
	}
	
	@GetMapping("/{user_id}/physical_gold_holdings")
	public double getTotalPhysicalGoldHoldings(@PathVariable("user_id") int userId) throws InvalidUserIDException, UserNotFoundException {
		
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		return Userserv.getTotalPhysicalGoldHoldings(userId);
	}
	
	@GetMapping("/{user_id}/transaction_history")
	public List<TransactionHistory> getTransactionHistory(@PathVariable("user_id") int userId) throws InvalidUserIDException, TransactionHistoryNotPresentException, UserNotFoundException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		List<TransactionHistory> list = Userserv.getTransactionHistory(userId);
		if(list.isEmpty()) {
			throw new TransactionHistoryNotPresentException("User has no transaction history");
		}
		return list;
	}
	
	@GetMapping("/{user_id}/payments")
	public List<Payments> getPayments(@PathVariable("user_id") int userId) throws InvalidUserIDException, PaymentsNotPresentException, UserNotFoundException {
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
		List<Payments> list = Userserv.getPaymentsById(userId);
		if(list.isEmpty()) {
			throw new PaymentsNotPresentException("User has no payments");
		}
		return list;
	}
	
	@PutMapping(value="/{user_id}/update_balance/{amount}")
	ResponseEntity<SuccessResponse> updateUsersBalance(@PathVariable("user_id") int userId, @PathVariable("amount") double amount) throws InvalidUserIDException, UserNotFoundException{
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid!");
		}
		Userserv.updateUsersBalance(userId, amount);
		SuccessResponse response = new SuccessResponse("Users balance updated successfully", LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(value="/{user_id}/update_address/{address_id}")
	ResponseEntity<SuccessResponse> updateUsersAddress(@PathVariable("user_id") int userId, @PathVariable("address_id") int addressId) throws InvalidUserIDException, UserNotFoundException{
		if(userId <= 0) {
			throw new InvalidUserIDException("The id given is invalid!");
		}
		Userserv.updateUsersAddressId(userId, addressId);
		SuccessResponse response = new SuccessResponse("Users balance updated successfully", LocalDateTime.now());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
