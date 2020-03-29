package com.plekhanov.react_web_service.entities;

import com.plekhanov.react_web_service.web.security.Role;
import lombok.Data;
import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @ElementCollection
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "name")
    private Set<Role> roles;
}
