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
import com.mobile101.tierlistAPI.tierlist.business.TierBusiness;
import com.mobile101.tierlistAPI.tierlist.json.TierJson;
import com.mobile101.tierlistAPI.tierlist.model.Tier;
import com.mobile101.tierlistAPI.tierlist.payload.TierPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierService;

@RestController
@RequestMapping("/api")
public class TierController {
    @Autowired
	TierService tierService;
	
	@Autowired
	TierBusiness tierBusiness;

	public TierController(TierService tierService) {
		this.tierService = tierService;
	}
	
	@PostMapping("/tiers")
	public ResponseEntity<Void> saveTier(@RequestBody TierPayload payload) throws BaseException {
		tierBusiness.saveTier(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/tiers")
	public ResponseEntity<List<TierJson>> getAllTiers() throws BaseException{
		return ResponseEntity.ok(tierBusiness.getListTier());
	}
	
	@GetMapping(value = "/tiers/{id}")
	public ResponseEntity<TierJson> getTierById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(tierBusiness.getTierId(id));
	}
	
    @PutMapping(value = "/tiers/{id}")
	public ResponseEntity<TierJson> updatetier(@PathVariable("id") long id, @RequestBody TierPayload payload){
		Optional<Tier> tierData = tierService.findOptionalById(id);
		if(tierData.isPresent()) {
			tierBusiness.updateTier(tierData.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/tiers/{id}")
	public ResponseEntity<TierJson> deleteTierById(@PathVariable("id") long id) {
		try {
			tierBusiness.deleteTier(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
