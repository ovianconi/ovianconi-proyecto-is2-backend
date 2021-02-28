package com.project.is2.entity;

import javax.persistence.*;

@Entity
@Table(name = "permits")
public class Permit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permit_id",nullable = false)
    private int id;
    
    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "display_name", length = 200)
    private String displayName;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
}
