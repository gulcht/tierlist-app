package com.mobile101.tierlistAPI.tierlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="Tiers")
@Table(
	name = "tiers"
)
public class Tier {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tier_id")
	private long id;
    
	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "color", nullable = true)
	private String color = "";

	public Tier() {
		
	}

	public Tier(String name){
		super();
        this.name = name;
	}

}
