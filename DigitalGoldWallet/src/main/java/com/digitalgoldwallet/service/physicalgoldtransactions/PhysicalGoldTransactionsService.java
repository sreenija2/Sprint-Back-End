package com.digitalgoldwallet.service.physicalgoldtransactions;

import java.util.List;

import com.digitalgoldwallet.exception.InvalidBranchIDException;
import com.digitalgoldwallet.exception.InvalidPhysicalGoldTransactionIDException;
import com.digitalgoldwallet.exception.InvalidUserIDException;
import com.digitalgoldwallet.exception.PhysicalGoldTransactionNotFoundException;
import com.digitalgoldwallet.model.PhysicalGoldTransactions;

public interface PhysicalGoldTransactionsService {
	public PhysicalGoldTransactions getPhysicalGoldTransactionsByTransactionId(int transaction_id) throws InvalidPhysicalGoldTransactionIDException, PhysicalGoldTransactionNotFoundException;
	public List<PhysicalGoldTransactions> getAllPhysicalGoldTransactions() throws PhysicalGoldTransactionNotFoundException;
	public List<PhysicalGoldTransactions> getPhysicalGoldTransactionsByUserId(int userId) throws InvalidPhysicalGoldTransactionIDException, PhysicalGoldTransactionNotFoundException, InvalidUserIDException;
	public List<PhysicalGoldTransactions> getPhysicalGoldTransactionsByBranchId(int BranchId) throws InvalidBranchIDException, PhysicalGoldTransactionNotFoundException;

}