package com.krishnasai.foodiesapi.Filters;

import com.krishnasai.foodiesapi.Util.JwtUtil;
import com.krishnasai.foodiesapi.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    private AppUserDetailsService userDetailsService;
}
