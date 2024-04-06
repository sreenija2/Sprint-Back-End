package com.digitalgoldwallet.dao.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.digitalgoldwallet.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{

	Optional<Users> findByName(String name);

	@Query("SELECT u FROM Users u WHERE u.address.city=:city ") //JPQL
	public List<Users> findByAddressesCity(@Param("city") String city);
	
	@Query("SELECT u FROM Users u WHERE u.address.state=:state ") //JPQL
	public List<Users> findByAddressesState(@Param("state") String state);

}