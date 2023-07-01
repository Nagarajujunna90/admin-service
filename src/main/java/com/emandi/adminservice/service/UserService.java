package com.emandi.adminservice.service;


import com.emandi.adminservice.model.User;

import java.util.List;

public interface UserService {

	void createUser(User userdto);
	void deleteUser(Integer id);
	User updateUser(Integer id, User userdto);
	public User findByUserId(Integer id);
	List<User> findAllUserDetails();

}
