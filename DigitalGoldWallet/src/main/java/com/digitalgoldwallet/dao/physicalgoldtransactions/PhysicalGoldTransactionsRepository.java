package com.digitalgoldwallet.dao.physicalgoldtransactions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalgoldwallet.model.PhysicalGoldTransactions;

@Repository
public interface PhysicalGoldTransactionsRepository extends JpaRepository<PhysicalGoldTransactions, Integer>{
	
	@Query("SELECT p FROM PhysicalGoldTransactions p WHERE p.user.userId=:userId") 	//JPQL
	public List<PhysicalGoldTransactions> findByUsersuserId(@Param("userId") int userId);
	
	@Query("SELECT p FROM PhysicalGoldTransactions p WHERE p.branch.branchid=:branchid") 	//JPQL
	public List<PhysicalGoldTransactions> findByVendorBranchesBranchId(@Param("branchid") int branchId);
	
}
