package com.emandi.adminservice.repository;


import com.emandi.adminservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer> {

}
