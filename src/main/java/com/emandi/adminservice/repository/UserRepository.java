package com.emandi.adminservice.repository;


import com.emandi.adminservice.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {




	

}
