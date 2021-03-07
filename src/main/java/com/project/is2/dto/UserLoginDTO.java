package com.project.is2.dto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.project.is2.entity.Role;
import com.project.is2.entity.User;

public class UserLoginDTO {

    
    public UserLoginDTO() {
    }

    public UserLoginDTO(User user){
        userId = user.getUserId();
        userName = user.getUserName();
        email = user.getEmail();
        nombre = user.getNombre();
        apellido = user.getApellido();
        roles = user.getRoles();
    }

    private Long userId;

	private String userName;

	private String email;

    private String nombre;

	private String apellido;

	private Set<Role> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    
	public Set<String> getPermits() {
		if(roles == null || roles.isEmpty()) {
			return Collections.emptySet();
		}

		List<List<String>> permitsList = roles.stream().map(r -> r.getPermits().stream()
								.map(rp -> rp.getPermit().getName()).collect(Collectors.toList()))
								.collect(Collectors.toList());

        Set<String> permitsString = new HashSet<>();
		permitsList.forEach(list -> permitsString.addAll(list));
		return permitsString;
	}

}
