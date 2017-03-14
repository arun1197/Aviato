package io.muic.ooc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.muic.ooc.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
	 User findByUsername(String username);
}
