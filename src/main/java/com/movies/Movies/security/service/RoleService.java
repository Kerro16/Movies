package com.movies.Movies.security.service;

import com.movies.Movies.security.entity.Role;
import com.movies.Movies.security.enums.RoleName;
import com.movies.Movies.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> getByName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Role role){
        roleRepository.save(role);
    }
}
