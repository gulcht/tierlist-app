package com.mobile101.tierlistAPI.tierlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.model.TierList;
import com.mobile101.tierlistAPI.tierlist.repository.TierListRepository;
import com.mobile101.tierlistAPI.tierlist.service.intf.ITierList;

@Service
public class TierListService implements ITierList{

    @Autowired
    TierListRepository tierListRepository;

    @Override
    public List<TierList> findAllTierLists() {
       return tierListRepository.findAll();
    }

    @Override
    public TierList findById(long id) {
        return tierListRepository.findById(id);
    }

    @Override
    public List<TierList> findByUserId(long id) {
        return tierListRepository.findByUserId(id);
    }

    @Override
    public TierList findByName(String name) {
        return tierListRepository.findByName(name);
    }

    @Override
    public TierList save(TierList tierList) {
       return tierListRepository.save(tierList);
    }

    @Override
    public void deleteById(long id) {
        tierListRepository.deleteById(id);
    }

    @Override
    public Optional<TierList> findOptionalById(long id) {
        return findOptionalById(id);
    }

}
