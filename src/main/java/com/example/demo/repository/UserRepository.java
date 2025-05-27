package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	// T-SQL, 注意:欄位名要符合資料表中的設定
	@Query(value = "select user_id, username, password_hash, salt, email, active, role from users where username=:username", nativeQuery = true)
	User getUser(String username); // 也可以用 findByUserName (有 3 種寫法, 寫其中一種就好)
	
	// PQL, 注意:欄位名要符合 entity 中的設定, 會自動生成 SQL)
//	@Query(value = "select u from User u where username=:username")
//	User readRooms(String username); 
	
	// 自動生成 SQL (JPA 會根據方法名稱解析出查詢邏輯, 自動生成 SQL)
//	User findByUsername(String username); 
	
	// T-SQL, 注意:欄位名要符合資料表中的設定
	@Query(value = "insert into user(username, hash_password, hash_salt, email) values(?, ?, ?, ?)", nativeQuery = true)
	User addUser(String username); 

	// T-SQL, 注意:欄位名要符合資料表中的設定
	@Query(value = "update user set active = true where username = ?", nativeQuery = true)
	User emailConfirmOK(String username); 
	boolean existsByUsername(String username);
	Optional<User> findByUsername(String username);
}
