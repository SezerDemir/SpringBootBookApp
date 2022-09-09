package com.sezer.jwt;

import com.sezer.user.Role;
import com.sezer.user.User;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = response.getHeader("Authorization");

        if(!hasAuthorizationHeader(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = getAccessToken(request);
        if(!jwtTokenUtil.validateAccessToken(accessToken)) {
            filterChain.doFilter(request, response);
            return;
        }
        setAuthenticationContext(accessToken, request);
        filterChain.doFilter(request, response);
    }

    private void setAuthenticationContext(String accessToken, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(accessToken);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserDetails getUserDetails(String accessToken) {
        User userDetails = new User();
        Claims claims = jwtTokenUtil.parseClaims(accessToken);
        String[] subjectArray = ((String) claims.get(Claims.SUBJECT)).split(",");
        String[] roles = ((String) claims.get("roles")).replace("[", "").replace("]", "").split(",");
        for (String r: roles) {
            userDetails.addRole(new Role(r));
        }

        userDetails.setId(Integer.parseInt(subjectArray[0]));
        userDetails.setEmail(subjectArray[1]);
        return userDetails;
    }

    private boolean hasAuthorizationHeader(HttpServletRequest req) {
        String header = req.getHeader("Authorization");
        if(ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
            return false;
        }
        return true;
    }

    private String getAccessToken(HttpServletRequest req) {
        String header = req.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        return token;
    }
}
