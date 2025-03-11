package tpe.Usuario.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tpe.Usuario.services.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	DefaultUserService userDetailsService;


	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration autheticationConfiguration)
			throws Exception {
		return autheticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}






	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable())  // Deshabilitar CSRF
				.authorizeHttpRequests(auth -> auth
						.requestMatchers(    "/v3/api-docs/**",
								"/swagger-ui/**",
								"/swagger-ui.html","/auth/login", "/auth/validateToken", "/error", "/auth/registro").permitAll()
						.anyRequest().authenticated()
				)
				.sessionManagement(session -> session
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Añadir filtro de autenticación JWT
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

/*	@Bean
	public JwtFilter authenticationTokenFilterBean() throws Exception {
		return new JwtFilter();  // Tu filtro personalizado para JWT
	}
*/




	@Bean
	public JwtFilter authenticationTokenFilterBean() throws Exception {
		return new JwtFilter();
	}

}