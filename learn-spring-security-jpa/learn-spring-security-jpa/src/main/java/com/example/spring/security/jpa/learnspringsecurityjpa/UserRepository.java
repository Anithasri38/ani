package com.example.spring.security.jpa.learnspringsecurityjpa;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.security.jpa.learnspringsecurityjpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
    Optional<User> findByUserName(String username);
}
