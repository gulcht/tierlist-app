package com.mobile101.tierlistAPI.tierlist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile101.tierlistAPI.exception.BaseException;
import com.mobile101.tierlistAPI.tierlist.business.ItemBusiness;
// import com.mobile101.tierlistAPI.tierlist.json.ItemsetJson;
import com.mobile101.tierlistAPI.tierlist.json.ItemJson;
import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.payload.ItemPayload;
import com.mobile101.tierlistAPI.tierlist.service.ItemService;

@RestController
@RequestMapping("/api")
public class ItemController {
    @Autowired
	ItemService itemService;
	
	@Autowired
	ItemBusiness itemBusiness;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@PostMapping("/items")
	public ResponseEntity<Void> saveItem(@RequestBody ItemPayload payload) throws BaseException {
		itemBusiness.saveItem(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/items")
	public ResponseEntity<List<ItemJson>> getAllItems() throws BaseException{
		return ResponseEntity.ok(itemBusiness.getListItem());
	}
	
	@GetMapping(value = "itemsets/{id}/items")
	public ResponseEntity<List<ItemJson>> getItemsByItemsetId(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(itemBusiness.getItemsByItemsetId(id));
	}

	@GetMapping(value = "/items/{id}")
	public ResponseEntity<ItemJson> getItemById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(itemBusiness.getItemId(id));
	}
	
    @PutMapping(value = "/items/{id}")
	public ResponseEntity<ItemJson> updateitem(@PathVariable("id") long id, @RequestBody ItemPayload payload){
		Optional<Item> itemData = itemService.findOptionalById(id);
		if(itemData.isPresent()) {
			itemBusiness.updateItem(itemData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/items/{id}")
	public ResponseEntity<ItemJson> deleteItemById(@PathVariable("id") long id) {
		try {
			itemBusiness.deleteItem(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

	

