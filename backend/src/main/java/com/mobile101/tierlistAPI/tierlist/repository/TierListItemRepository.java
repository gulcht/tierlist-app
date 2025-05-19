package com.mobile101.tierlistAPI.tierlist.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mobile101.tierlistAPI.tierlist.model.TierListItem;

@Repository

public interface TierListItemRepository extends JpaRepository<TierListItem, Long> {
    List<TierListItem> findByTierListId(long tierListId);

    TierListItem findById(long id);

    Optional<TierListItem> findOptionalById(long id);
}
