package main.app.security;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Component
public class ExternalTokenAuthenticationFilter extends OncePerRequestFilter {

    private final RestTemplate restTemplate;

    public ExternalTokenAuthenticationFilter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    protected void doFilterInternal(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, jakarta.servlet.FilterChain filterChain) throws jakarta.servlet.ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            ResponseEntity<String> validationResponse = restTemplate.exchange(
                    "http://localhost:8090/auth/validateToken",
                    HttpMethod.POST,
                    new HttpEntity<>(null, createHeaders(token)),
                    String.class
            );

            if (validationResponse.getStatusCode() == HttpStatus.OK) {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, String> responseBody = objectMapper.readValue(validationResponse.getBody(), new TypeReference<Map<String, String>>() {});
                String role = responseBody.get("role");
                if (role != null) {
                    role = "ROLE_" + role.toUpperCase();
                    Authentication auth = new ExternalServiceAuthenticationToken(token, List.of(new SimpleGrantedAuthority(role)));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
        }
        filterChain.doFilter(request, response);
        }

    private HttpHeaders createHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return headers;
    }
}
