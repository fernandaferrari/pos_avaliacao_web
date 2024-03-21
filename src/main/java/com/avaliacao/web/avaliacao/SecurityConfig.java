package com.avaliacao.web.avaliacao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	@SuppressWarnings("deprecation")
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
             .requestMatchers("/css/**", "/cadastro.html")
             .permitAll() // Permitir acesso a arquivos CSS
             .anyRequest().authenticated()
             .and()
			.formLogin(form -> form
					.loginPage("/login")
					.permitAll()
			);
	return http.build();
	}
    
    @Bean
    UserDetailsService users(DataSource dataSource) {
    	UserDetails user = User.builder()
    		.username("nome")
    		.password("senha")
    		.roles("Usuario")
    		.build();
    	JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
    	users.createUser(user);
    	return users;
    }
}
