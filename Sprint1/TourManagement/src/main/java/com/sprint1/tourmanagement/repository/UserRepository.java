package com.sprint1.tourmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sprint1.tourmanagement.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByuserUserId(String userUserId);
	User findByuserPassword(String userPassword);
	User findByuserType(String userType);
	
	@Query("select u from User u where u.userType=:uType and u.userUserId=:uId and u.userPassword=:password")
	public User doLogin(@Param("uType") String userType,@Param("uId") String userId,@Param("password") String password);
}
