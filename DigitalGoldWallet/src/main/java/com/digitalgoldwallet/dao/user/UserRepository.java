package com.digitalgoldwallet.dao.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitalgoldwallet.model.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{

	Optional<Users> findByName(String name);

}