package com.example.cidades.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Autowired
    private UserDetailsSecurityServer userDetailsSecurityServer;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(cors -> cors.disable())
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.POST, "/api/usuarios").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/auth").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/cidades").authenticated()
                .requestMatchers(HttpMethod.PUT, "/api/cidades/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/api/cidades/**").authenticated()
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        http.addFilter(new JwtAuthenticationFilter(
            authenticationManager(authenticationConfiguration),
            jwtUtil
        ));

        http.addFilter(new JwtAuthorizationFilter(
            authenticationManager(authenticationConfiguration),
            jwtUtil, userDetailsSecurityServer
        ));

        return http.build();
    }
}
