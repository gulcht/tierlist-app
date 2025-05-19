package com.mobile101.tierlistAPI.tierlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile101.tierlistAPI.tierlist.model.Tier;
import com.mobile101.tierlistAPI.tierlist.repository.TierRepository;
import com.mobile101.tierlistAPI.tierlist.service.intf.ITier;

@Service
public class TierService implements ITier{
    
    @Autowired
    TierRepository tierRepository;

    @Override
    public List<Tier> findAllTiers() {
        return tierRepository.findAll();
    }

    @Override
    public Tier findById(long id) {
       return tierRepository.findById(id);
    }

    @Override
    public Tier findByName(String name) {
      return tierRepository.findByName(name);
    }

    @Override
    public Tier save(Tier tier) {
       return tierRepository.save(tier);
    }

    @Override
    public void deleteById(long id) {
        tierRepository.deleteById(id);
    }

    @Override
    public Optional<Tier> findOptionalById(long id) {
        return tierRepository.findOptionalById(id);
    }
    
}
