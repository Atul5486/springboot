package com.Basic_Authentication.filters;

import com.Basic_Authentication.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/auth/")
                || path.startsWith("/swagger-ui/")
                || path.startsWith("/v3/api-docs")
                || path.startsWith("/webjars/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        String token = null;
        if (authorization == null || !authorization.startsWith("Bearer")) {
            throw new RuntimeException("Authorization failed");
        }
        token = authorization.substring(7);

        Claims claims = jwtUtils.validateToken(token);
        String email = claims.getSubject();

        String role = claims.get("role", String.class);

        String path = request.getRequestURI();

        if (path.startsWith("/admin") && !role.equals("ADMIN")) {
            throw new RuntimeException("Invalid url with respect to role admin path");
        }
        if (path.startsWith("/user") &&
                !role.equals("ADMIN") &&
                !role.equals("USER")) {
            throw new RuntimeException("Invalid url with respect to role user path");
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                email,
                null,
                List.of(new SimpleGrantedAuthority("ROLE_" + role))
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);
    }

}

