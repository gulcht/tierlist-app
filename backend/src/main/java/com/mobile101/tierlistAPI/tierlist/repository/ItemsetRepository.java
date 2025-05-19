package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.Itemset;

@Repository
public interface ItemsetRepository extends JpaRepository<Itemset, Long>{
    Itemset findById(long id);
    Itemset findByName(String name);
    Optional<Itemset> findOptionalById(long id);
}
