package com.sandu.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    @Bean
    public SecurityConfig securityConfig(HttpSecurity http) throws Exception{
      http
           .formLogin(form -> {
            form.loginPage(null).permitAll();
           })
           .authorizeHttpRequests(registry -> {
            registry.requestMatchers("/**").permitAll();
            registry.anyRequest().authenticated();
           });

      return new SecurityConfig();
    }

}
