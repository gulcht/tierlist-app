package com.mobile101.tierlistAPI.tierlist.json;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierListJson {
    private long id;
    private String name;
    private User user;
    private LocalDateTime createdAt;
    private String description;

    public static TierListJson packJson(TierList tierList) {
		TierListJson tierListJson = new TierListJson();
		tierListJson.setId(tierList.getId());
		tierListJson.setName(tierList.getName());
        tierListJson.setUser(tierList.getUser());
        tierListJson.setCreatedAt(tierList.getCreatedAt());
        tierListJson.setDescription(tierList.getDescription());
		return tierListJson;
	}
	
	public static List<TierListJson> packJsons(List<TierList> tierLists) {
		List<TierListJson> tierListListJson = new ArrayList<TierListJson>();
		for(TierList tierList:tierLists) {
			tierListListJson.add(packJson(tierList));
		}
		return tierListListJson;
	}
}
