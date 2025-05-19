package com.mobile101.tierlistAPI.tierlist.json;

import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.Tier;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierJson {
    private long id;
    private String name;
	private String color;

    public static TierJson packJson(Tier tier) {
		TierJson tierJson = new TierJson();
		tierJson.setId(tier.getId());
        tierJson.setName(tier.getName());
		tierJson.setColor(tier.getColor());
		return tierJson;
	}
	
	public static List<TierJson> packJsons(List<Tier> tiers) {
		List<TierJson> tierListJson = new ArrayList<TierJson>();
		for(Tier tier:tiers) {
			tierListJson.add(packJson(tier));
		}
		return tierListJson;
	}
}
