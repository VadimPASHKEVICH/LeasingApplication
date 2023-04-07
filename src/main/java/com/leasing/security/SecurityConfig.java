package com.leasing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    CustomUserDetailsService customUserDetailsService;

    @Autowired
    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChainByUser(HttpSecurity httpUser) throws Exception {
        return httpUser
                .authorizeRequests()
                .antMatchers("/registration", "/user").permitAll()
                .antMatchers("/user/update", "/user/{id}").hasRole("USER")
                .antMatchers("/agreement/allAg", "/agreement/getBy{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers("/info/allInfo", "/info/getInfoBy{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers("/card/createCard", "/card/updateCard", "/card/deleteCard").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChainByAdmin(HttpSecurity httpAdmin) throws Exception {
        return httpAdmin
                .authorizeRequests()
                .antMatchers("/user/create", "user/deleteUser{id}", "/user/all").hasRole("ADMIN")
                .antMatchers("/agreement/createAg", "/agreement/updateAg", "/agreement/deleteAg").hasRole("ADMIN")
                .antMatchers("/info/createInfo", "info/updateInfo", "/info/deleteAgInfo").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

