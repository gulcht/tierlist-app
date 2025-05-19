package com.mobile101.tierlistAPI.tierlist.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.json.TierListJson;
import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.payload.TierListPayload;
import com.mobile101.tierlistAPI.tierlist.service.TierListService;

@Service
public class TierListBusiness {
    @Autowired
	TierListService tierListService;
	
	public List<TierListJson> getListTierList() {
		return TierListJson.packJsons(tierListService.findAllTierLists());
	}
	public TierListJson getTierListId(long id) {
		return TierListJson.packJson(tierListService.findById(id));
	}
	public List<TierListJson> getTierListByUserId(long id) {
		return TierListJson.packJsons(tierListService.findByUserId(id));
	}
	public void saveTierList(TierListPayload tierListPayload) {
		TierList tierList = new TierList(
				tierListPayload.getName(), 
                tierListPayload.getUser(),
				tierListPayload.getDescription(),
                tierListPayload.getCreatedAt());
		tierListService.save(tierList);
	}
	public void updateTierList(long id, TierListPayload tierListPayload) {
		TierList tierListData = tierListService.findById(id);
		tierListData.setName(tierListPayload.getName());
		tierListData.setUser(tierListPayload.getUser());
		tierListData.setDescription(tierListPayload.getDescription());
        tierListData.setCreatedAt(tierListPayload.getCreatedAt());
		tierListService.save(tierListData);
	}
	public void deleteTierList(long id) {
		tierListService.deleteById(id);
	}
}
