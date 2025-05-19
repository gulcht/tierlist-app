package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.TierList;

@Repository
public interface TierListRepository extends JpaRepository<TierList, Long>{
    TierList findById(long id);
	List<TierList> findByUserId(long id);
	TierList findByName(String name);
	Optional<TierList> findOptionalById(long id);
}
