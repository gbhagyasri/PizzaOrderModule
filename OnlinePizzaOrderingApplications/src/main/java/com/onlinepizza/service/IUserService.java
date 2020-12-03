package com.onlinepizza.service;

import java.util.Optional;

import com.onlinepizza.model.User;

public interface IUserService {

			public User  addNewUser(User user);

			public  User signIn(Integer id,String password);

			public String  signOut(User user);
			
			Optional<User> getUserById(Integer id);
			
		}

