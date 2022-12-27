package com.sprint1.tourmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.tourmanagement.entity.User;
import com.sprint1.tourmanagement.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("createNewUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User user1=userService.saveUser(user);
		ResponseEntity<User> responseEntity=new ResponseEntity<>(user1,HttpStatus.CREATED);
		return responseEntity;		
	}
	
	@GetMapping("user/login/{userType}/{userId}/{password}")
	public ResponseEntity<String> doLogin(@PathVariable("userType") String userType,@PathVariable("userId") String userId,@PathVariable("password") String password){
		String user=userService.userLogin(userType, userId, password);
		ResponseEntity<String> responseEntity=new ResponseEntity<>(user,HttpStatus.OK);
		return responseEntity;	
	}
	
	@PutMapping("Update_User_Details")
	public ResponseEntity<User> modifyUser(@RequestBody User user){
		User user1=userService.updateUser(user);
		ResponseEntity<User> responseEntity=new ResponseEntity<>(user1,HttpStatus.OK);
		return responseEntity;
	}
}

