package io.muic.ooc.service;

import java.util.Arrays;
import java.util.HashSet;

import io.muic.ooc.repository.RoleRepository;
import io.muic.ooc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.muic.ooc.model.Role;
import io.muic.ooc.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByUsername(String email) {
		return userRepository.findByUsername(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRole(userRole);
		userRepository.save(user);
	}

}
