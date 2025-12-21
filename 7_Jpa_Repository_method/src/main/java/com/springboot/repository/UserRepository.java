package com.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springboot.entity.User;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer>{
	
	 List<User> findByUsername(String username);
	 List<User> findByGender(String gender);
	 List<User> findByAddress(String address);
	 
	 List<User> findByHobbies(String hobby);
	 List<User> findByGenderAndAddress(String gender, String address);
	 List<User> findByGenderOrAddress(String gender, String address);
	 List<User> findByGenderNot(String gender);
	 
	 List<User> findByAge(int age);
	 
	 List<User> findByUsernameContaining(String username);
	 List<User> findByUsernameIgnoreCase(String username);
	 List<User> findByUsernameContainingIgnoreCase(String username);
	 
	 
	 List<User> findByAddressIn(List<String> address);
	 List<User> findByGenderOrderByAddressDesc(String gender);
	 
	 
	 Page<User> findByGender(String gender,Pageable pageable);
	 
	 List<User> searchByAddress(@Param("address") String address);
	 List<User> searchByGender(@Param("gender") String gender);

	 @Query("select u from User u JOIN u.hobbies h where h=:hobby")
	 List<User> searchByHobby(@Param("hobby") String hobby);
	 
	 @Query(value="select * from user_jpa where address = :address",nativeQuery = true)
	 List<User> searchByAddressAgain(@Param("address") String address);
	
}