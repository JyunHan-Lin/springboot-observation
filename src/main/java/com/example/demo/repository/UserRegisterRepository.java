package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.entity.User;


public interface UserRegisterRepository extends JpaRepository<User, Integer>{
	
	// T-SQL, 注意:欄位名要符合資料表中的設定
	@Query(value = "insert into user(username, hash_password, hash_salt, email) values(?, ?, ?, ?)", nativeQuery = true)
	User addUser(String username); 

	// T-SQL, 注意:欄位名要符合資料表中的設定
	@Query(value = "update user set active = true where username = ?", nativeQuery = true)
	User emailConfirmOK(String username); 
	boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);
}
