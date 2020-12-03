package com.onlinepizza.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.model.User;
import com.onlinepizza.service.IUserService;

@RestController
@RequestMapping("users")
@Validated
	public class UserController {
		@Autowired
		private IUserService userService;
		/*
		 * login
		 */
		@PostMapping("/signIn/{userid}/{password}")
		public String signIn(@PathVariable Integer userid,@PathVariable String password) {
			User user1 = userService.signIn(userid,password);
			if(user1!=null) return "SigninSuccessfull";
			else return "InvalidPassword or Id,If a newuser add your details and proceed";
			
			}
		@GetMapping("/find/{id}") // http://localhost:1205/users/find/
		public Optional<User> getUserById(@PathVariable("id") Integer id){
			Optional<User> entity =userService.getUserById(id);
			return entity;
		}
		/*
		 * adding user
		 */
		@PostMapping("/addNewUser")
		public ResponseEntity<String> add(@Valid @RequestBody User user) {
			User user1 = userService.addNewUser(user);
			String str="Thanks Save your UserId-";
			String id=user1.getUserId().toString();

			return new ResponseEntity<>(str.concat(id), HttpStatus.OK);
		}
		/*
		 * forgotPassword
		 */
		@GetMapping("/forgotPass/{id}/{Username}") // http://localhost:1205/users/find/
		public String getPassword(@PathVariable("id") Integer id,@PathVariable String username){
			Optional<User> entity =userService.getUserById(id);
			User obj=entity.get();
			if(username.equals(obj.getUserName()))
				return obj.getPassword().concat(" is the passwsord,Thanks for using forgotPassword option");
			return "WrongUserName Or Id";
		}
		/*
		 * signOut user
		 */
		
		@PostMapping(value="/signOut")
		public void signOutUser(@RequestBody User user){
			 userService.signOut(user);
		
	}
		
		
}

