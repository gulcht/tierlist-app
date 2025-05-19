package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.User;

public interface IUser {
    List<User> findAllUsers();
	User findById(long id);
	User findByEmail(String email);
	User login(String email, String password);
	User save(User user);
	void deleteById(long id);
	Optional<User> findOptionalById(long id);
}
