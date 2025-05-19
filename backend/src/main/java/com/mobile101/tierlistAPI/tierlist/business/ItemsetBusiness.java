package com.mobile101.tierlistAPI.tierlist.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.ItemsetJson;
import com.mobile101.tierlistAPI.tierlist.model.Itemset;
import com.mobile101.tierlistAPI.tierlist.payload.ItemsetPayload;
import com.mobile101.tierlistAPI.tierlist.service.ItemsetService;

@Service
public class ItemsetBusiness {
    @Autowired
    ItemsetService itemSetService;
	
	public List<ItemsetJson> getListItemset() {
		return ItemsetJson.packJsons(itemSetService.findAllCategories());
	}
	public ItemsetJson getItemsetId(long id) {
		return ItemsetJson.packJson(itemSetService.findById(id));
	}

	public long saveItemset(ItemsetPayload itemSetPayload) {
		Itemset itemSet = new Itemset(
				itemSetPayload.getName(),
                itemSetPayload.getImage());
		itemSetService.save(itemSet);
		return itemSet.getId();
	}
	public void updateItemset(long id, ItemsetPayload itemSetPayload) {
		Itemset itemSetData = itemSetService.findById(id);
		itemSetData.setName(itemSetPayload.getName());
		itemSetService.save(itemSetData);
	}
	public void deleteItemset(long id) {
		itemSetService.deleteById(id);
	}
}
