package com.cosodi.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 60, unique = true)
    private String username;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 60)
    private String password;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(nullable = false)
    private boolean enabled;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false,
                    foreignKey = @ForeignKey(name = "FK_USER_ROLES_USER")),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false,
                    foreignKey = @ForeignKey(name = "FK_USER_ROLES_ROLES")))
    private List<Role> roles;

    public User(String username, String password, boolean enabled, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
        this.registrationDate = LocalDateTime.now();
    }

    public User(String username, String email, String password, String firstName, String lastName, boolean enabled, List<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enabled = enabled;
        this.roles = roles;
        this.registrationDate = LocalDateTime.now();
    }
}
