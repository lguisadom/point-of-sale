package com.cosodi.pos.security;

import com.cosodi.pos.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final Role role;
    @Override
    public String getAuthority() {
        return role.getName().toString();
    }
}
