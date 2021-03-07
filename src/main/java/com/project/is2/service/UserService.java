package com.project.is2.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.is2.dto.UserLoginDTO;
import com.project.is2.entity.User;
import com.project.is2.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private EntityManager entityManager;

	@Autowired
	public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
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
		User currentUser = userRepository.findByUserId(user.getUserId());

		if(!user.getEncrytedPassword().equals(currentUser.getEncrytedPassword())) {
			user.setEncrytedPassword(bCryptPasswordEncoder.encode(user.getEncrytedPassword()));
		}

        return userRepository.save(user);
    }

	public UserLoginDTO isAuthenticated(String username, String password) {
		String sql = "Select e from " + User.class.getName() + " e " //
				+ " Where e.userName = :user";

		Query query = entityManager.createQuery(sql, User.class);
		query.setParameter("user", username);

		if (!query.getResultList().isEmpty()) {
			User userFromDB = (User) query.getSingleResult();
			if (password.equals(userFromDB.getEncrytedPassword())
					|| bCryptPasswordEncoder.matches(password, userFromDB.getEncrytedPassword())) {
				
				User user = userRepository.findByUserId(userFromDB.getUserId());
				return new UserLoginDTO(user);
			}
		}
		return null;
	}
}