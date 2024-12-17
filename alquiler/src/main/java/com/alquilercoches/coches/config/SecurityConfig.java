package com.alquilercoches.coches.config;

import com.alquilercoches.coches.models.entities.Usuario;
import com.alquilercoches.coches.models.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Lazy; // Importar la anotación Lazy

import java.util.ArrayList;
import java.util.List;

@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;


	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	public SecurityConfig(@Lazy CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/registro/**", "/css/**", "/js/**", "/images/**", "/h2-console/**").permitAll()
						.anyRequest().authenticated()
				)
				.formLogin(form -> form
						.loginPage("/login").permitAll()
						.defaultSuccessUrl("/coche", true)
				)
				.logout(logout -> logout.permitAll())
				.csrf().disable()
				.headers().frameOptions().disable();

		return http.build();
	}



}