package com.project.is2.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;
    
    @Column(name = "role")
    private String role;

	@JsonIgnoreProperties({"role"})
	@OneToMany(mappedBy = "role")
	private List<RolePermit> permits;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public List<RolePermit> getPermits() {
		return permits;
	}

	public void setPermits(List<RolePermit> permits) {
		this.permits = permits;
	}
}
