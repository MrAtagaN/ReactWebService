package com.plekhanov.react_web_service.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Date;

/**
 * Обработка JWT токена
 */
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtService {

    long validityTokenInMilliseconds;
    String secretKey;


    public JwtService(@Value("${jwt.validityinmilliseconds}") long validityTokenInMilliseconds,
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


    public boolean validateToken(final String token) {
        if (token == null) {
            return false;
        }
        final Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
        return !claimsJws.getBody().getExpiration().before(new Date());
    }


    public String getEmailFromToken(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }
}
