package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.Tier;

@Repository
public interface TierRepository extends JpaRepository<Tier, Long>{
    Tier findById(long id);
    Tier findByName(String name);
    Optional<Tier> findOptionalById(long id);
}
