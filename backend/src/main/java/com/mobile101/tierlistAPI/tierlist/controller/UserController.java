package com.mobile101.tierlistAPI.tierlist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile101.tierlistAPI.exception.BaseException;
import com.mobile101.tierlistAPI.tierlist.business.UserBusiness;
import com.mobile101.tierlistAPI.tierlist.json.UserJson;
import com.mobile101.tierlistAPI.tierlist.model.User;
import com.mobile101.tierlistAPI.tierlist.payload.UserPayload;
import com.mobile101.tierlistAPI.tierlist.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
	UserService userService;
	
	@Autowired
	UserBusiness userBusiness;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Void> saveUser(@RequestBody UserPayload payload) throws BaseException {
		userBusiness.saveUser(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserJson>> getAllUsers() throws BaseException{
		return ResponseEntity.ok(userBusiness.getListUser());
	}
	
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UserJson> getUserById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(userBusiness.getUserId(id));
	}

	@PutMapping(value = "/users/{id}")
	public ResponseEntity<UserJson> updateUser(@PathVariable("id") long id, @RequestBody UserPayload payload){
		Optional<User> userData = userService.findOptionalById(id);
		if(userData.isPresent()) {
			userBusiness.updateUser(userData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserJson> deleteUserById(@PathVariable("id") long id) {
		try {
			userBusiness.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User userBody) {
        User user = userService.login(userBody.getEmail(), userBody.getPassword());
		System.out.println(userBody.getEmail()+ '\n'+userBody.getPassword());
        if (user != null) {
			User userData = new User();
			userData.setId(user.getId());
			userData.setUsername(user.getUsername());
			userData.setEmail(user.getEmail());
			userData.setImage(user.getImage());
			userData.setCreatedAt(user.getCreatedAt());

			
			return ResponseEntity.ok(userData);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
