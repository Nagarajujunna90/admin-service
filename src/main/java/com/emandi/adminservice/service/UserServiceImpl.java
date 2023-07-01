package com.emandi.adminservice.service;


import com.emandi.adminservice.model.Role;
import com.emandi.adminservice.model.User;
import com.emandi.adminservice.repository.RoleRepository;
import com.emandi.adminservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepositroy;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Override
	public void createUser(User user) {
		List<Role> roles = roleRepository.findAll();
		Set<Role> roles1 =new HashSet<>();
		roles1.add(new Role("Admin"));
		user.setRoles(roles1);
		User user1 = userRepositroy.save(user);
		sendMessage(String.valueOf(user1));

	}
	public void sendMessage(String msg) {
		String topicName="test";
		kafkaTemplate.send(topicName, msg);
	}
	@Override
	public void deleteUser(Integer id) {
		userRepositroy.deleteById(id);
		
	}

	@Override
	public User updateUser(Integer id, User user) {
		user.setId(id);
		user.setUserName(user.getUserName());
		user.setPassword(user.getPassword());
		user.setFirstName(user.getFirstName());
		user.setLastName(user.getLastName());
		user.setFatherName(user.getFatherName());
		user.setQualification(user.getQualification());
		return userRepositroy.save(user);
	}

	@Override
	public User findByUserId(Integer id) {
		 User user=userRepositroy.findById(id).orElse(null);
		return user;
	}

	@Override
	public List<User> findAllUserDetails() {
    List<User>	userlist=(List<User>)userRepositroy.findAll();
		return userlist;
	}

}
