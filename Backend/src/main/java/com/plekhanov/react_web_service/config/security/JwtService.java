package com.plekhanov.react_web_service.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Base64;
import java.util.Date;

/**
 * Создание и обработка JWT токена
 */
@Service
@Validated
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtService {

    long validityTokenInMilliseconds;
    String secretKey;


    public JwtService(@Value("${jwt.validityinmilliseconds}") long validityTokenInMilliseconds,
                      @Value("${jwt.secretkey}") String secretKey) {

        this.validityTokenInMilliseconds = validityTokenInMilliseconds;
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }


    public String createJwtToken(@NotNull final String email) {
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


    public boolean validateToken(@NotNull final String token) {
        final Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return !claimsJws.getBody().getExpiration().before(new Date());
    }


    public String getEmailFromToken(@NotNull final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
