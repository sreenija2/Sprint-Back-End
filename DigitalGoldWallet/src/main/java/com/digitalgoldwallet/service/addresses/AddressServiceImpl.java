package com.digitalgoldwallet.service.addresses;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalgoldwallet.dao.addresses.AddressRepository;
import com.digitalgoldwallet.exception.AddressNotFoundException;
import com.digitalgoldwallet.exception.DuplicateAddressIDException;
import com.digitalgoldwallet.exception.InvalidAddressIDException;
import com.digitalgoldwallet.model.Addresses;


@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressRepository AddrDao;
 
	@Override
	public List<Addresses> GetAllAddresses() {
		// TODO Auto-generated method stub
		return AddrDao.findAll();
	}
 
	@Override
	public Addresses GetAddressById(int addressId) throws InvalidAddressIDException, AddressNotFoundException {
		// TODO Auto-generated method stub
		Optional<Addresses> address=AddrDao.findById(addressId);
		if(addressId <= 0) {
			throw new InvalidAddressIDException("Given addressId is invalid");
		}
		if(!address.isPresent()) {
			throw new AddressNotFoundException("Address not found");
		}
		return address.get();
	}
    @Transactional
	@Override
	public Addresses addAddress(Addresses address) throws DuplicateAddressIDException {
		Optional<Addresses> newaddress = AddrDao.findById(address.getAddressId());
		if(newaddress.isPresent()) {
			throw new DuplicateAddressIDException("Address with this ID is already present");
		}
		// TODO Auto-generated method stub
		return AddrDao.saveAndFlush(address);
		
		
//		System.out.println("added successfully");
		
	}
 
	@Override
	@Transactional
	public Addresses updateAddress(Addresses addressId) throws AddressNotFoundException{
		// TODO Auto-generated method stub
		Optional<Addresses> address=AddrDao.findById(addressId.getAddressId());
		if(!address.isPresent()) {
			throw new AddressNotFoundException("Address with this ID is not found");
		}
		Addresses id=address.get();
		id.setCity(addressId.getCity());
		id.setState(addressId.getState());
		id.setCountry(addressId.getCountry());
		id.setPostalCode(addressId.getPostalCode());
		id.setStreet(addressId.getStreet());
		return id;
	}
 
}


