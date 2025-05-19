package com.mobile101.tierlistAPI.tierlist.payload;

import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.model.Tier;
import com.mobile101.tierlistAPI.tierlist.model.TierList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TierListItemPayload {
    private TierList tiserList;
    private Item item;
    private Tier tier;    
}
