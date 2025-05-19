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
@Entity(name="Items")
@Table(
	name = "items"
)

public class Item {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemset_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Itemset itemset;

    @Column(name = "image", nullable = false, columnDefinition = "LONGTEXT")
	private String image;
    
	public Item() {
		
	}

	public Item(Itemset itemset, String image){
		super();
		this.itemset = itemset;
        this.image = image;
	}

}
