package com.cosodi.pos.repository;

import com.cosodi.pos.entity.Role;
import com.cosodi.pos.util.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(RoleName name);
}
