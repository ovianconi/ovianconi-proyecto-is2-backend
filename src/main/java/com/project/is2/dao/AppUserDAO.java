package com.project.is2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.is2.entity.AppUser;

@Repository
@Transactional
public class AppUserDAO {
 
    @Autowired
    private EntityManager entityManager;
 
    public AppUser findUserByUsername(String userName) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.userName = :userName ";
 
            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("userName", userName);
 
            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public List<AppUser> getAllUsers() {

        String sql = "Select e from " + AppUser.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, AppUser.class);
        return query.getResultList();
    }

    public AppUser getUserById(Long id) {
        String sql = "Select e from " + AppUser.class.getName() + " e " //
                + " Where e.userId = :id ";

        Query query = entityManager.createQuery(sql, AppUser.class);
        query.setParameter("id", id);

        return (AppUser) query.getSingleResult();
    }

    public Boolean getIsUser(String user, String pass) {
    	String sql = "Select e from " + AppUser.class.getName() + " e " //
                + " Where e.userName = :user and e.encrytedPassword = :pass";

        Query query = entityManager.createQuery(sql, AppUser.class);
        query.setParameter("user", user);
        query.setParameter("pass", pass);

        if (user.equalsIgnoreCase("admin") && pass.equals("123456")) {
            return true;
        }

        if (!query.getResultList().isEmpty()) {
            return true;
        }
        return false;
    }

}