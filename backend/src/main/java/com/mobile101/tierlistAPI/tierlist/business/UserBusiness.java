package com.mobile101.tierlistAPI.tierlist.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.UserJson;
import com.mobile101.tierlistAPI.tierlist.model.User;
import com.mobile101.tierlistAPI.tierlist.payload.UserPayload;
import com.mobile101.tierlistAPI.tierlist.service.UserService;

@Service
public class UserBusiness {
    @Autowired
	UserService userService;
	
	public List<UserJson> getListUser() {
		return UserJson.packJsons(userService.findAllUsers());
	}
	public UserJson getUserId(long id) {
		return UserJson.packJson(userService.findById(id));
	}
	public UserJson getUserByEmail(String email) {
		return UserJson.packJson(userService.findByEmail(email));
	}
	public void saveUser(UserPayload userPayload) {
		User user = new User(
				userPayload.getUsername(), 
                userPayload.getPassword(),
				userPayload.getEmail(),
                userPayload.getCreatedAt(),
				userPayload.getImage());
		userService.save(user);
	}
	public void updateUser(long id, UserPayload userPayload) {
		User userData = userService.findById(id);
		userData.setUsername(userPayload.getUsername());
		userData.setPassword(userPayload.getPassword());
		userData.setEmail(userPayload.getEmail());
        userData.setCreatedAt(userPayload.getCreatedAt());
		userData.setImage(userPayload.getImage());
		userService.save(userData);
	}
	public void deleteUser(long id) {
		userService.deleteById(id);
	}
}
