package com.plekhanov.react_web_service.services.impl;

import com.plekhanov.react_web_service.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Base64;
import java.util.Date;


@Service
@Validated
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtServiceImpl implements JwtService {

    long validityTokenInMilliseconds;
    String secretKey;


    public JwtServiceImpl(@Value("${jwt.validityTokenInMilliseconds}") long validityTokenInMilliseconds,
                          @Value("${jwt.secretkey}") String secretKey) {

        this.validityTokenInMilliseconds = validityTokenInMilliseconds;
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }


    public String createJwtToken(final String email) {
        final Claims claims = Jwts.claims().setSubject(email);
        final Date now = new Date();
        final Date validity = new Date(now.getTime() + validityTokenInMilliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }


    public String validateTokenAndGetEmail(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }


}
