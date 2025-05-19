package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findById(long id);
	User findByEmail(String email);
	Optional<User> findOptionalById(long id);
}
