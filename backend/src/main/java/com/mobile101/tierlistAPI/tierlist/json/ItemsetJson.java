package com.mobile101.tierlistAPI.tierlist.json;

import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.Itemset;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemsetJson {
    private long id;
    private String name;
    private String image;

    public static ItemsetJson packJson(Itemset itemSet) {
		ItemsetJson itemSetJson = new ItemsetJson();
		itemSetJson.setId(itemSet.getId());
		itemSetJson.setName(itemSet.getName());
		itemSetJson.setImage(itemSet.getImage());
		return itemSetJson;
	}
	
	public static List<ItemsetJson> packJsons(List<Itemset> itemSets) {
		List<ItemsetJson> itemSetListJson = new ArrayList<ItemsetJson>();
		for(Itemset itemSet:itemSets) {
			itemSetListJson.add(packJson(itemSet));
		}
		return itemSetListJson;
	}
}
