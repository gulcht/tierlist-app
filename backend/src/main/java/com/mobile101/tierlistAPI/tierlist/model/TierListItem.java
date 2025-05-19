package com.mobile101.tierlistAPI.tierlist.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="TierListItems")
@Table(
	name = "tierlistitems"
)
public class TierListItem {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tierlistitem_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tierlist_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private TierList tierList;
	
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tier_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Tier tier;

	public TierListItem() {
		
	}

    public TierListItem(TierList tierList, Item item, Tier tier) {
		super();
        this.tierList = tierList;
        this.item = item;
        this.tier = tier;
	}
}
