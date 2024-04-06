package com.digitalgoldwallet.service.physicalgoldtransactions;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalgoldwallet.dao.physicalgoldtransactions.PhysicalGoldTransactionsRepository;
import com.digitalgoldwallet.exception.InvalidBranchIDException;
import com.digitalgoldwallet.exception.InvalidPhysicalGoldTransactionIDException;
import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.PhysicalGoldTransactionNotFoundException;
import com.digitalgoldwallet.model.PhysicalGoldTransactions;



@Service
public class PhysicalGoldTransactionsServiceImpl implements PhysicalGoldTransactionsService{

	@Autowired
	PhysicalGoldTransactionsRepository physicalGoldTransactionsDao;
	
	@Override
	public PhysicalGoldTransactions getPhysicalGoldTransactionsByTransactionId(int transactionId) throws InvalidPhysicalGoldTransactionIDException, PhysicalGoldTransactionNotFoundException {
		Optional<PhysicalGoldTransactions> phyGoldTran = physicalGoldTransactionsDao.findById(transactionId);
		if(transactionId <= 0) {
			throw new InvalidPhysicalGoldTransactionIDException("The transaction id given is invalid");
		}
		if(!phyGoldTran.isPresent()) {
			throw new PhysicalGoldTransactionNotFoundException("Physical Gold Transaction with this id is not present");
		}
		return phyGoldTran.get();
	}
	
	@Override
	public List<PhysicalGoldTransactions> getAllPhysicalGoldTransactions() throws PhysicalGoldTransactionNotFoundException{
		List<PhysicalGoldTransactions> phyList = physicalGoldTransactionsDao.findAll();
		if(phyList.isEmpty()) {
			throw new PhysicalGoldTransactionNotFoundException("No physical gold transactions found");
		}
		return phyList;
	}

	@Override
	public List<PhysicalGoldTransactions> getPhysicalGoldTransactionsByUserId(int userId) throws InvalidPhysicalGoldTransactionIDException, PhysicalGoldTransactionNotFoundException, InvalidUserIDException {
		
		if(userId <= 0) {
			throw new InvalidUserIDException("The user id given is invalid");
		}
		List<PhysicalGoldTransactions> list = physicalGoldTransactionsDao.findByUsersuserId(userId);
		if(list.isEmpty()) {
			throw new PhysicalGoldTransactionNotFoundException("No physical gold transactions found for this user");
		}
		return list;
		
	}

	@Override
	public List<PhysicalGoldTransactions> getPhysicalGoldTransactionsByBranchId(int branchId) throws InvalidBranchIDException, PhysicalGoldTransactionNotFoundException {
		if(branchId <= 0) {
			throw new InvalidBranchIDException("The branch id given is invalid");
		}
		List<PhysicalGoldTransactions> list = physicalGoldTransactionsDao.findByVendorBranchesBranchId(branchId);
		if(list.isEmpty()) {
			throw new PhysicalGoldTransactionNotFoundException("No physical gold transactions found for this branch");
		}
		return null;
	}
}
