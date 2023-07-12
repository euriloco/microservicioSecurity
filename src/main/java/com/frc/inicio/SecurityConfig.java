package com.frc.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
//definición roles y usuarios
	@Bean
	public InMemoryUserDetailsManager usersDetailsMemory() throws Exception {
		List<UserDetails> users = List.of(User.withUsername("user1").password("{noop}user1").roles("INVITADO").build(),
				User.withUsername("user2").password("{noop}user2").roles("OPERADOR").build(),
				User.withUsername("user3").password("{noop}user3").roles("ADMIN").build(),
				User.withUsername("user4").password("{noop}user4").roles("OPERADOR", "ADMIN").build());
		return new InMemoryUserDetailsManager(users);
	}

//acceso a recursos
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    http.csrf(cr -> cr.disable())
	            .authorizeHttpRequests(authorize -> authorize
	                    .requestMatchers(HttpMethod.POST, "/alta").hasRole("ADMIN")
	                    .requestMatchers(HttpMethod.PUT, "/actualizar/**").hasAnyRole("ADMIN", "OPERADOR")
	                    .requestMatchers(HttpMethod.DELETE, "/borrado/**").hasAnyRole("ADMIN", "OPERADOR")
	                    .anyRequest().authenticated())
	            .httpBasic(Customizer.withDefaults());
	    return http.build();
	}
}