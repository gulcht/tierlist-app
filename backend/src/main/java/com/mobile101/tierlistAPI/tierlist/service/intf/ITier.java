package com.mobile101.tierlistAPI.tierlist.service.intf;

import java.util.List;
import java.util.Optional;

import com.mobile101.tierlistAPI.tierlist.model.Tier;

public interface ITier {
    List<Tier> findAllTiers();
    Tier findById(long id);
    Tier findByName(String name);
    Tier save(Tier tier);
    void deleteById(long id);
    Optional<Tier> findOptionalById(long id);
}
