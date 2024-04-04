package com.digitalgoldwallet.controller.addresses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalgoldwallet.exception.AddressNotFoundException;
import com.digitalgoldwallet.exception.DuplicateAddressIDException;
import com.digitalgoldwallet.exception.InvalidAddressIDException;
import com.digitalgoldwallet.model.Addresses;
import com.digitalgoldwallet.service.addresses.AddressService;

@RestController
@RequestMapping(value="/api/v1/address")
public class AddressController {
	
	@Autowired
	AddressService AddrServ;
	
	@GetMapping()
	List<Addresses>GetAllAddresses(){
		System.out.println("get the addreeses");
		List<Addresses>addresses=AddrServ.GetAllAddresses();
		return addresses;
	}
	
	@GetMapping(path="{address_id}")
	ResponseEntity<Addresses> GetAddressById(@PathVariable("address_id") int address_id) throws InvalidAddressIDException, AddressNotFoundException {
	Addresses address=AddrServ.GetAddressById(address_id);
	if(address_id <= 0) {
		throw new InvalidAddressIDException("Address ID is invalid");
	}
	else if(address == null) {
		throw new AddressNotFoundException("Address is not found");
	}
		//System.out.println(address);
	return new ResponseEntity<Addresses>(address,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	void addAddress(@RequestBody Addresses address) throws DuplicateAddressIDException{
		
		Addresses newaddress = AddrServ.addAddress(address);
		if(newaddress != null) {
			throw new DuplicateAddressIDException("Address with this ID is already present");
		}
		AddrServ.addAddress(address);
		System.out.println("Successfully added");	
	}
	
	@PutMapping("/update/{address_id}")
	ResponseEntity<Addresses> updateAddress(@RequestBody Addresses add) throws AddressNotFoundException{
		Addresses address=AddrServ.updateAddress(add);
		if(address == null) {
			throw new AddressNotFoundException("Address with this ID is not found");
		}
		System.out.println("Address id in controller");
		return new ResponseEntity<Addresses>(address,HttpStatus.ACCEPTED);
		
	}
		
	
	
 
}