package com.grabhub.config;


import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class AppConfig {

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/**").authenticated().anyRequest())
                .addFilterBefore(new JwtValidator(), BasicAuthenticationFilter.class).csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(new CorsConfigurationSource() {	
                	// 	in this method i used lambda 
                	
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {

                        CorsConfiguration cfg = new CorsConfiguration();

                        cfg.setAllowedOrigins(Arrays.asList(

                                "http://localhost:3000"
                        ));
                        cfg.setAllowedMethods(Collections.singletonList("*"));
                        // to allow the all access all methods like put,get,post etc..
                        cfg.setAllowCredentials(true);
                        cfg.setAllowedHeaders(Collections.singletonList("*"));
                        cfg.setExposedHeaders(Arrays.asList("Authorization"));
                        cfg.setMaxAge(3600L);
                        return null;
                    }
                }));
                
		
		return http.build();
	}
	@Bean
	public  PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}
