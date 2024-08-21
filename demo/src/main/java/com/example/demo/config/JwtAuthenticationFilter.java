package com.example.demo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException
    {
        String token = request.getHeader(JwtConstant.JWT_HEADER);

        System.out.println(token);

        if( token!=null ){

            token = token.substring(7);

            SecretKey key = Keys.hmacShaKeyFor(JwtConstant.JWT_KEY.getBytes());

            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println(claims);

            // Get Username or Email
            String email = String.valueOf(claims.get("sub"));
            String authorities = String.valueOf(claims.get("authorities"));
            System.out.println(authorities);

            Authentication auth = new UsernamePasswordAuthenticationToken(email, null,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(authorities)
                    );

            System.out.println(auth);

            SecurityContextHolder.getContext().setAuthentication(auth);

        }

        filterChain.doFilter(request, response);
    }

//    @Override
//    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
//        String path = request.getServletPath();
//        return path.equals("/api/auth/login");
//    }
}
