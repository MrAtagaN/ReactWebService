package com.plekhanov.react_web_service.dao;

import com.plekhanov.react_web_service.entities.UserRegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistrationDao extends JpaRepository<UserRegistrationRequest, Integer> {

    UserRegistrationRequest findByEmail(String email);

}
