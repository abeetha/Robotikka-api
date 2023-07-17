package com.bootcamp.robotikka.robotikkaapi.repo;

import com.bootcamp.robotikka.robotikkaapi.dto.core.ApplicationUser;
import com.bootcamp.robotikka.robotikkaapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User,String> {
   @Query(value = "SELECT * FROM user_table WHERE role_id=?",nativeQuery = true)
   public List<User> findAllAdmins(String admin);

   public Optional<User> findByPrefix(String prefix);

   public Optional<User> findByEmail(String email);
}
