package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.Itemset;

public interface IItemset {
    List<Itemset> findAllCategories();
    Itemset findById(long id);
    Itemset findByName(String name);
    Itemset save(Itemset category);
    void deleteById(long id);
    Optional<Itemset> findOptionalById(long id);
}
