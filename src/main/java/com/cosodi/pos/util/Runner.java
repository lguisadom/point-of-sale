package com.cosodi.pos.util;

import com.cosodi.pos.entity.Role;
import com.cosodi.pos.entity.User;
import com.cosodi.pos.repository.IRoleRepository;
import com.cosodi.pos.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

    private final IUserRepository iUserRepository;
    private final IRoleRepository iRoleRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello world!");
        if (this.iRoleRepository.count() == 0) {
            this.iRoleRepository.saveAll(List.of(
                    new Role(RoleName.ADMIN, "ADMIN"),
                    new Role(RoleName.READ, "READ"),
                    new Role(RoleName.WRITE, "WRITE")
            ));
        }

        if (this.iUserRepository.count() == 0) {
            this.iUserRepository.saveAll(List.of(
                    new User("admin", new BCryptPasswordEncoder().encode("admin123"), true, List.of(iRoleRepository.findByName(RoleName.ADMIN).get())),
                    new User("user01", "user01123", true, List.of(iRoleRepository.findByName(RoleName.READ).get())),
                    new User("user02", "user02123", true, List.of(iRoleRepository.findByName(RoleName.WRITE).get()))
            ));
        }
    }
}
