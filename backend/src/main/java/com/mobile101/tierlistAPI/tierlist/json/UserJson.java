package com.mobile101.tierlistAPI.tierlist.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserJson {
    private long id;
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private String image;

    public static UserJson packJson(User user) {
		UserJson userJson = new UserJson();
		userJson.setId(user.getId());
		userJson.setUsername(user.getUsername());
		userJson.setPassword(user.getPassword());
		userJson.setEmail(user.getEmail());
		userJson.setImage(user.getImage());
        userJson.setCreatedAt(user.getCreatedAt());
		return userJson;
	}
	
	public static List<UserJson> packJsons(List<User> users) {
		List<UserJson> userListJson = new ArrayList<UserJson>();
		for(User user:users) {
			userListJson.add(packJson(user));
		}
		return userListJson;
	}
}
