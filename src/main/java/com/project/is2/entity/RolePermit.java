package com.project.is2.entity;

import javax.persistence.*;

@Entity
@Table(name = "role_permit")
public class RolePermit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    
    @ManyToOne(targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne(targetEntity = Permit.class)
    @JoinColumn(name = "permit_id")
    private Permit permit;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Permit getPermit() {
        return permit;
    }

    public void setPermit(Permit permit) {
        this.permit = permit;
    }
}
