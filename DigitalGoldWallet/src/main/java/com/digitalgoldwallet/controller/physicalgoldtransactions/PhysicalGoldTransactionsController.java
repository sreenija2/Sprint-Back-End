package com.digitalgoldwallet.controller.physicalgoldtransactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.digitalgoldwallet.exception.InvalidPhysicalGoldTransactionIDException;
import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.PhysicalGoldTransactionNotFoundException;
import com.digitalgoldwallet.model.PhysicalGoldTransactions;
import com.digitalgoldwallet.service.physicalgoldtransactions.PhysicalGoldTransactionsService;
import com.digitalgoldwallet.service.physicalgoldtransactions.PhysicalGoldTransactionsServiceImpl;

@RestController
//@Validated
@RequestMapping(value="/api/v1/physical_gold_transactions")
public class PhysicalGoldTransactionsController {
	
	@Autowired
	PhysicalGoldTransactionsService physicalGoldTransactionsServ;
	
	@GetMapping
	public ResponseEntity<List<PhysicalGoldTransactions>> getAllPhysicalGoldTransactions() throws PhysicalGoldTransactionNotFoundException{
		List<PhysicalGoldTransactions> phyList = physicalGoldTransactionsServ.getAllPhysicalGoldTransactions();
		if(phyList.isEmpty()) {
			throw new PhysicalGoldTransactionNotFoundException("No physical gold transactions found");
		}
		return new ResponseEntity<>(phyList,HttpStatus.OK);
	}
	
	@GetMapping(value="{transaction_id}")
	public ResponseEntity<PhysicalGoldTransactions> getPhysicalGoldTransactionsById(@PathVariable("transaction_id") int id) throws PhysicalGoldTransactionNotFoundException, InvalidPhysicalGoldTransactionIDException{
		PhysicalGoldTransactions phy = physicalGoldTransactionsServ.getPhysicalGoldTransactionsByTransactionId(id);
		if(id <= 0) {
			throw new InvalidPhysicalGoldTransactionIDException("The transaction id given is invalid");
		}
		if(phy == null) {
			throw new PhysicalGoldTransactionNotFoundException("No physical gold transaction found with this id");
		}
		return new ResponseEntity<>(phy,HttpStatus.OK);
	}
	
	@GetMapping(value="/byUser/{user_id}")
	public ResponseEntity<List<PhysicalGoldTransactions>> getPhysicalGoldTransactionsByUserId(@PathVariable("user_id") int userId) throws InvalidPhysicalGoldTransactionIDException, PhysicalGoldTransactionNotFoundException, InvalidUserIDException {
		
		if(userId <= 0) {
			throw new InvalidUserIDException("The user id given is invalid");
		}
		List<PhysicalGoldTransactions> list = physicalGoldTransactionsServ.getPhysicalGoldTransactionsByUserId(userId);
		if(list.isEmpty()) {
			throw new PhysicalGoldTransactionNotFoundException("No physical gold transactions found for this user");
		}
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
}
