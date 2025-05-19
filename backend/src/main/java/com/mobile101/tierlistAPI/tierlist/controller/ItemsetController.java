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
import com.mobile101.tierlistAPI.tierlist.business.ItemsetBusiness;
import com.mobile101.tierlistAPI.tierlist.json.ItemsetJson;
import com.mobile101.tierlistAPI.tierlist.model.Itemset;
import com.mobile101.tierlistAPI.tierlist.payload.ItemsetPayload;
import com.mobile101.tierlistAPI.tierlist.service.ItemsetService;

@RestController
@RequestMapping("/api")
public class ItemsetController {
    @Autowired
	ItemsetService itemSetService;
	
	@Autowired
	ItemsetBusiness itemSetBusiness;

	public ItemsetController(ItemsetService itemSetService) {
		this.itemSetService = itemSetService;
	}
	
	@PostMapping("/itemsets")
	public ResponseEntity<Long> saveItemset(@RequestBody ItemsetPayload payload) throws BaseException {
		Long itemSetId = itemSetBusiness.saveItemset(payload);
		return new ResponseEntity<>(itemSetId, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/itemsets")
	public ResponseEntity<List<ItemsetJson>> getAllCategories() throws BaseException{
		return ResponseEntity.ok(itemSetBusiness.getListItemset());
	}
	
	@GetMapping(value = "/itemsets/{id}")
	public ResponseEntity<ItemsetJson> getItemsetById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(itemSetBusiness.getItemsetId(id));
	}
	
    @PutMapping(value = "/itemsets/{id}")
	public ResponseEntity<ItemsetJson> updateitemSet(@PathVariable("id") long id, @RequestBody ItemsetPayload payload){
		Optional<Itemset> itemSetData = itemSetService.findOptionalById(id);
		if(itemSetData.isPresent()) {
			itemSetBusiness.updateItemset(itemSetData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/itemsets/{id}")
	public ResponseEntity<ItemsetJson> deleteItemsetById(@PathVariable("id") long id) {
		try {
			itemSetBusiness.deleteItemset(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
