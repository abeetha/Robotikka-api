package com.bootcamp.robotikka.robotikkaapi.repo;

import com.bootcamp.robotikka.robotikkaapi.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRoleRepo extends JpaRepository<UserRole,String> {
    public Optional<UserRole> findByRoleName(String rolename);
}
