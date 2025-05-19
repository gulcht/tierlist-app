package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.TierListItem;

public interface ITierListItem {
    List<TierListItem> findAllTierListItems();
    TierListItem findById(long id);
    List<TierListItem> findByTierListId(long id);
    TierListItem save(TierListItem tierListItem);
    void deleteById(long id);
    Optional<TierListItem> findOptionalById(long id);
}
