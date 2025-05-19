package com.mobile101.tierlistAPI.tierlist.json;

import java.util.ArrayList;
import java.util.List;

import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.Tier;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierListItemJson {
    private long id;
    private TierList tierlist;
    private Item item;
    private Tier tier;

    public static TierListItemJson packJson(TierListItem tierListItem) {
		TierListItemJson tierListItemJson = new TierListItemJson();
        tierListItemJson.setId(tierListItem.getId());
		tierListItemJson.setTierlist(tierListItem.getTierList());
		tierListItemJson.setItem(tierListItem.getItem());
		tierListItemJson.setTier(tierListItem.getTier());
		return tierListItemJson;
	}
	
	public static List<TierListItemJson> packJsons(List<TierListItem> tierListItems) {
		List<TierListItemJson> tierListItemListJson = new ArrayList<TierListItemJson>();
		for(TierListItem tierListItem:tierListItems) {
			tierListItemListJson.add(packJson(tierListItem));
		}
		return tierListItemListJson;
	}
}
