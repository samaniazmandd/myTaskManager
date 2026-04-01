package com.example.myTaskManager.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;


    @Value("${jwt.expiration}")
    private long expiration;


    public String generateToken(String username){
        String token= Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return token;
    }

    public String extractUsername(String token){
        String tokenWithoutUsername= Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return tokenWithoutUsername;

    }

    public boolean validateToken(String token, String username){
        String tokenUsername=extractUsername(token);
        return (username.equals(tokenUsername)&& !isTokenExpired(token));
    }


    private boolean isTokenExpired(String token){
        Date expirationDate=Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();

        return expirationDate.before(new Date());

    }
}
