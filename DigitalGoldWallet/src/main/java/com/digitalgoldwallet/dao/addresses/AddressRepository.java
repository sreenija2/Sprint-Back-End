package com.digitalgoldwallet.dao.addresses;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalgoldwallet.model.Addresses;

@Repository
public interface AddressRepository extends JpaRepository<Addresses,Integer>{
	
	

}
