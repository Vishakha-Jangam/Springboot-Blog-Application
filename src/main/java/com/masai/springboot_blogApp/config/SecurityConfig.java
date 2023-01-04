package com.masai.springboot_blogApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.masai.springboot_blogApp.Security.JwtAuthenticationEntryPoint;
import com.masai.springboot_blogApp.Security.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig{
	
	private UserDetailsService userDetailsService;
	
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	public SecurityConfig(UserDetailsService userDetailsService,
			JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
			JwtAuthenticationFilter jwtAuthenticationFilter) {
		this.userDetailsService=userDetailsService;
		this.jwtAuthenticationEntryPoint=jwtAuthenticationEntryPoint;
		this.jwtAuthenticationFilter=jwtAuthenticationFilter;
	}
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests((authorize) ->
		
		//authorize.anyRequest().authenticated()
		authorize.requestMatchers(HttpMethod.GET,"/api/**").permitAll()
		.requestMatchers("/api/auth/**").permitAll()
		.anyRequest().authenticated()
		).exceptionHandling(exception ->
		exception.authenticationEntryPoint(jwtAuthenticationEntryPoint))
		.sessionManagement(session -> session.sessionCreationPolicy
				(SessionCreationPolicy.STATELESS));
		
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationToken.class);
		
		
		
		return http.build();
		
	}
	
//    @Bean
//    public UserDetailsService userDetailsService() {
//	 UserDetails user= User.builder().username("vishakha")
//			 .password(passwordEncoder().encode("pass")).roles("USER").build();
//	 UserDetails admin= User.builder().username("admin")
//			 .password(passwordEncoder().encode("admin")).roles("ADMIN").build();
//	 
//	 return new InMemoryUserDetailsManager(user,admin);
// 		
// 	}
	
}
