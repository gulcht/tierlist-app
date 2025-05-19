package com.mobile101.tierlistAPI.tierlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.model.Item;
import com.mobile101.tierlistAPI.tierlist.repository.ItemRepository;
import com.mobile101.tierlistAPI.tierlist.service.intf.IItem;

@Service
public class ItemService implements IItem{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(long id) {
        return itemRepository.findById(id);
    }

    // @Override
    // public Item findByName(String name) {
    //     return itemRepository.findByName(name);
    // }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> findByItemsetId(long id) {
        return itemRepository.findByItemsetId(id);
    }

    @Override
    public Optional<Item> findOptionalById(long id) {
       return itemRepository.findOptionalById(id);
    }
    
}
