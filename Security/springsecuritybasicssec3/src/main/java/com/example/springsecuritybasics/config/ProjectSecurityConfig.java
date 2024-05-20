package com.example.springsecuritybasics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("test")
                .password("test")
                .authorities("admin")
                .build();
//        UserDetails user3=User.withDefaultPasswordEncoder()
//                .username(username)
//                .password(password)
//                .authorities(role)
//                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("shivam")
                .password("test")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager();
    }

    @Autowired
    private DataSource dataSource; // or @Autowired private JdbcTemplate jdbcTemplate;


//    @Bean
//    public UserDetailsService userDetailsService() {
//        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager();
//        userDetailsManager.setDataSource(dataSource); // or userDetailsManager.setJdbcTemplate(jdbcTemplate);
//        return userDetailsManager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/myAccount","/myBalance","/myCards","/myLoans").authenticated()
                        .requestMatchers("/notices","/contact","/register").permitAll());
        http.csrf(configurer->configurer.disable());
        http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
