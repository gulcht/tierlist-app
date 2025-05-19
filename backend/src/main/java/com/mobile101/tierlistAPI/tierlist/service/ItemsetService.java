package com.mobile101.tierlistAPI.tierlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.model.Itemset;
import com.mobile101.tierlistAPI.tierlist.repository.ItemsetRepository;
import com.mobile101.tierlistAPI.tierlist.service.intf.IItemset;

@Service
public class ItemsetService implements IItemset{
    
    @Autowired
    ItemsetRepository itemsetRepository;

    @Override
    public List<Itemset> findAllCategories() {
       return itemsetRepository.findAll();
    }

    @Override
    public Itemset findById(long id) {
       return itemsetRepository.findById(id);
    }

    @Override
    public Itemset findByName(String name) {
       return itemsetRepository.findByName(name);
    }

    @Override
    public Itemset save(Itemset itemSet) {
       return itemsetRepository.save(itemSet);
    }

    @Override
    public void deleteById(long id) {
        itemsetRepository.deleteById(id);
    }

    @Override
    public Optional<Itemset> findOptionalById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOptionalById'");
    }
}
