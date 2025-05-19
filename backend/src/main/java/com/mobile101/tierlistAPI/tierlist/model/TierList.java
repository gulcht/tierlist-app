package com.mobile101.tierlistAPI.tierlist.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

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

@Entity(name="TierLists")
@Table(
	name = "tierlists"
)
public class TierList {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tierlist_id")
	private Long id;
    
	@Column(name = "name", nullable = false)
	private String name;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private User user;

    @Column(name = "description", nullable = true)
	private String description;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, 
			updatable = false, insertable = false)
	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createdAt;

    public TierList(){

    }

    public TierList(String name, User user, String description, LocalDateTime createdAt){
        super();
        this.name = name;
        this.user = user;
        this.description = description;
        this.createdAt = createdAt;
    }
}
