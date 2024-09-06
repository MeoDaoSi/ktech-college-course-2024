package com.example.demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.PrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long validityInMs;

    public SecretKey getSecretKey() {
        System.out.println(secretKey + " <<< secretKey");
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(Authentication auth) {

        Map<String, Object> claims = new HashMap<>();

        SecretKey key = getSecretKey();

        return Jwts.builder()
                .setSubject(auth.getName())
                .addClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // >>>>>>>>>>>>>>> Start Extract Data From Token <<<<<<<<<<<<<<<

    public String extractUsername( String token ) {
        return extractClaim(token, Claims::getSubject);
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // >>>>>>>>>>>>>>> End Extract Data From Token <<<<<<<<<<<<<<<

    public <T> T extractClaim( String token, Function<Claims, T> claimsResolver ) {
        final Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims getClaims( String token ) {
        return Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // >>>>>>>>>>>>>>> Start Validate Token <<<<<<<<<<<<<<<

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // >>>>>>>>>>>>>>> End Validate Token <<<<<<<<<<<<<<<
}
