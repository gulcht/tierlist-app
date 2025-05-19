package com.mobile101.tierlistAPI.tierlist.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.ItemJson;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.payload.ItemPayload;
import com.mobile101.tierlistAPI.tierlist.service.ItemService;

@Service
public class ItemBusiness {
    @Autowired
	ItemService itemService;
	
	public List<ItemJson> getListItem() {
		return ItemJson.packJsons(itemService.findAllItems());
	}
	public ItemJson getItemId(long id) {
		return ItemJson.packJson(itemService.findById(id));
	}
	public List<ItemJson> getItemsByItemsetId(long id) {
		return ItemJson.packJsons(itemService.findByItemsetId(id));
	}

	public void saveItem(ItemPayload itemPayload) {
		Item item = new Item(
				// itemPayload.getName(),
                // itemPayload.getDescription(),
                itemPayload.getItemset(),
                itemPayload.getImage());
		itemService.save(item);
	}
	public void updateItem(long id, ItemPayload itemPayload) {
		Item itemData = itemService.findById(id);
		// itemData.setName(itemPayload.getName());
		itemService.save(itemData);
	}
	public void deleteItem(long id) {
		itemService.deleteById(id);
	}
}
