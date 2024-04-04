package com.digitalgoldwallet.service.addresses;

import java.util.List;

import com.digitalgoldwallet.exception.AddressNotFoundException;
import com.digitalgoldwallet.exception.DuplicateAddressIDException;
import com.digitalgoldwallet.exception.InvalidAddressIDException;
import com.digitalgoldwallet.model.Addresses;

public interface AddressService {
	
	public List<Addresses> GetAllAddresses();
	public Addresses GetAddressById(int addressId) throws InvalidAddressIDException, AddressNotFoundException;
	public  Addresses addAddress(Addresses address) throws DuplicateAddressIDException;
	Addresses updateAddress(Addresses addressId) throws AddressNotFoundException;

}
