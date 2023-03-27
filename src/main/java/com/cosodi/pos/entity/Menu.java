package com.cosodi.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 20)
    private String icon;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_roles",
            joinColumns = @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_MENU_ROLES_MENU")),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false,
                foreignKey = @ForeignKey(name = "FK_MENU_ROLES_ROLES")))
    private List<Role> roles;
}
