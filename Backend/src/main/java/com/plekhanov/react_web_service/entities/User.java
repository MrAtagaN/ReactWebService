package com.plekhanov.react_web_service.entities;

import com.plekhanov.react_web_service.web.security.Role;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

/**
 *
 */
@Data
@Entity(name = "User")
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Security info
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ElementCollection()
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "name")
    private Set<Role> authorities;

    @Column(name = "account_non_expired")
    private boolean accountNonExpired;

    @Column(name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    //Public info
    @Column(name = "last_enter", columnDefinition = "TIMESTAMP")
    private LocalDateTime lastEnter;

}
