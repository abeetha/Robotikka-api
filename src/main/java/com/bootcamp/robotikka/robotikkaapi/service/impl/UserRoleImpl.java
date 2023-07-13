package com.bootcamp.robotikka.robotikkaapi.service.impl;

import com.bootcamp.robotikka.robotikkaapi.entity.User;
import com.bootcamp.robotikka.robotikkaapi.entity.UserRole;
import com.bootcamp.robotikka.robotikkaapi.entity.share.UserNameResource;
import com.bootcamp.robotikka.robotikkaapi.repo.UserRepo;
import com.bootcamp.robotikka.robotikkaapi.repo.UserRoleRepo;
import com.bootcamp.robotikka.robotikkaapi.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserRoleImpl implements UserRoleService {
    private final UserRoleRepo userRoleRepo;
    private final UserRepo userRepo;

    @Autowired
    public UserRoleImpl(UserRoleRepo userRoleRepo, UserRepo userRepo) {
        this.userRoleRepo = userRoleRepo;

        this.userRepo = userRepo;
    }

    @Override
    public void initializeRoles() {
        List<UserRole> userRoles = userRoleRepo.findAll();
        UserRole adminRole=null;
        if(userRoles.isEmpty()){
            UserRole role1 = new UserRole("UR-1","ADMIN","Super privilages",null);
            UserRole role2 = new UserRole("UR-2","MANAGER","Management privilages",null);
            UserRole role3 = new UserRole("UR-3","USER","Regular user",null);
            adminRole=role1;
            userRoleRepo.saveAll(List.of(role1,role2,role3));
        }

    }
}
