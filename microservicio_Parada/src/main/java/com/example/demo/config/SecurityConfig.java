package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.Security.ExternalTokenAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final ExternalTokenAuthenticationFilter externalTokenAuthenticationFilter;

    public SecurityConfig(ExternalTokenAuthenticationFilter externalTokenAuthenticationFilter) {
        this.externalTokenAuthenticationFilter = externalTokenAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                        //		"**",
                        //		"/**",
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html/**",
                                "/swagger-ui.html",
                                "/openapi/swagger-ui/**",
                                "/openapi/monopatin-api.yaml"
                        ).permitAll()
                        .anyRequest().hasAnyRole("USER", "ADMIN")
                )
                .addFilterBefore(externalTokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


}