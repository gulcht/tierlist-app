package com.mobile101.tierlistAPI.tierlist.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mobile101.tierlistAPI.tierlist.json.TierListItemJson;
import com.mobile101.tierlistAPI.tierlist.model.TierListItem;
import com.mobile101.tierlistAPI.tierlist.payload.TierListItemPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierListItemService;

@Service
public class TierListItemBusiness {
    @Autowired
	TierListItemService tierListItemService;
	
	public List<TierListItemJson> getListTierListItem() {
		return TierListItemJson.packJsons(tierListItemService.findAllTierListItems());
	}
	public List<TierListItemJson> getById(long id) {
		return TierListItemJson.packJsons(tierListItemService.findByTierListId(id));
	}
	public void saveTierListItem(TierListItemPayload tierListItemPayload) {
		TierListItem tierListItem = new TierListItem(
				tierListItemPayload.getTiserList(), 
                tierListItemPayload.getItem(),
				tierListItemPayload.getTier());
		tierListItemService.save(tierListItem);
	}
	public void updateTierListItem(long id, TierListItemPayload tierListItemPayload) {
		TierListItem tierListItemData = tierListItemService.findById(id);
        tierListItemData.setTierList(tierListItemPayload.getTiserList());
		tierListItemData.setItem(tierListItemPayload.getItem());
		tierListItemData.setTier(tierListItemPayload.getTier());
		tierListItemService.save(tierListItemData);
	}
	public void deleteTierListItem(long id) {
		tierListItemService.deleteById(id);
	}
	
}
