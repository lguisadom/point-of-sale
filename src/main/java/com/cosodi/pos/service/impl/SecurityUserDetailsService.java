package com.cosodi.pos.service.impl;

import com.cosodi.pos.exception.ModelNotFoundException;
import com.cosodi.pos.repository.IUserRepository;
import com.cosodi.pos.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {
    private final IUserRepository iUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.iUserRepository.findByUsername(username);

        if (optUser.isPresent()) {
            return new SecurityUser(optUser.get());
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
