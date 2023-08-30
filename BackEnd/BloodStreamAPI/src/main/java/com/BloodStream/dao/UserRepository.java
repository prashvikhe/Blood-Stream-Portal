package com.BloodStream.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.BloodStream.pojos.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  Optional<User> findByUsername(String username);
  Optional<User> findByEmail(String email);
  Boolean existsByUsername(String username);
  Boolean existsByEmail(String email);
  //User findUsersByCampId(Long campId);
}
