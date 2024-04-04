package com.digitalgoldwallet.controller.user;

import java.time.LocalDateTime;
import java.util.List;

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
import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.UserNotFoundException;
import com.digitalgoldwallet.model.Users;
import com.digitalgoldwallet.service.users.UsersService;

@RestController
@Validated
@RequestMapping(value="/api/v1/users")
public class UsersController {
	
	@Autowired
	UsersService Userserv;
	
	@GetMapping
	List<Users>GetAllUsers(){
		
		System.out.println("get the users");
		List<Users> users = Userserv.GetAllUsers();
		return users;
		
	}
	
	@GetMapping(path="{user_id}")
	ResponseEntity<Users> findUserByID(@PathVariable("user_id") int user_id) throws UserNotFoundException, InvalidUserIDException {
		Users user=Userserv.findUserByID(user_id);
		if(user_id <= 0) {
			throw new InvalidUserIDException("The id given is invalid");
		}
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
	ResponseEntity<SuccessResponse> addUsers(@Valid @RequestBody Users users) throws InvalidUserIDException{
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
	
	

}
