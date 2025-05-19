package com.mobile101.tierlistAPI.tierlist.payload;

import java.time.LocalDateTime;

import com.mobile101.tierlistAPI.tierlist.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierListPayload {
    private String name;
    private User user;
    private LocalDateTime createdAt;
    private String description;
}
