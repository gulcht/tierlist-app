package com.mobile101.tierlistAPI.tierlist.json;

import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.Itemset;
import com.mobile101.tierlistAPI.tierlist.model.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemJson {
    private long id;
	private	Itemset itemset;
    private String image;

    public static ItemJson packJson(Item item) {
		ItemJson itemJson = new ItemJson();
		itemJson.setId(item.getId());
		itemJson.setItemset(item.getItemset());
        itemJson.setImage(item.getImage());
		return itemJson;
	}
	
	public static List<ItemJson> packJsons(List<Item> items) {
		List<ItemJson> itemListJson = new ArrayList<ItemJson>();
		for(Item item:items) {
			itemListJson.add(packJson(item));
		}
		return itemListJson;
	}
}
