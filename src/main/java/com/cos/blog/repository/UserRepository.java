package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}

// JPA 네이밍 전략
// SELECT * FROM user WHERE username = ? AND password = ?;
//    User findByUsernameAndPassword(String username, String password);