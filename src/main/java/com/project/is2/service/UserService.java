package com.project.is2.service;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.is2.entity.User;
import com.project.is2.repository.RoleRepository;
import com.project.is2.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
    private EntityManager entityManager;
	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findUserByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}

	public User saveUser(User user) {
		User userNew = new User();

		userNew.setEncrytedPassword(bCryptPasswordEncoder.encode(user.getEncrytedPassword()));
		userNew.setEnabled(true);
		userNew.setUserName(user.getUserName());
		userNew.setNombre(user.getNombre());
		userNew.setApellido(user.getApellido());
		userNew.setEmail(user.getEmail());
		userNew.setRoles(user.getRoles());
		return userRepository.save(userNew);
	}
	
	@Transactional
    public User updateUser(User user) {
        userRepository.save(user);
        return user;
    }
	
	public User isAuthenticated(String username, String password) {
		
		String encrytedPassword = bCryptPasswordEncoder.encode(password);
		String sql = "Select e from " + User.class.getName() + " e " //
                + " Where e.userName = :user and e.encrytedPassword = :pass";

        Query query = entityManager.createQuery(sql, User.class);
        query.setParameter("user", username);
        query.setParameter("pass", encrytedPassword);

        if (!query.getResultList().isEmpty()) {
            return (User) query.getSingleResult();
        }
		return null;
	}
}