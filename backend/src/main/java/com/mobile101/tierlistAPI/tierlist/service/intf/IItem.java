package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.Item;

public interface IItem {
    List<Item> findAllItems();
    Item findById(long id);
    List<Item> findByItemsetId(long id);
    // Item findByName(String name);
    Item save(Item item);
    void deleteById(long id);
    Optional<Item> findOptionalById(long id);
}
