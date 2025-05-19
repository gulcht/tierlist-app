package com.mobile101.tierlistAPI.tierlist.payload;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPayload {
    private String username;
    private String email;
    private String password;
    private LocalDateTime createdAt;
    private String image;
}
