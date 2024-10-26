package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        //创建一个内存用户详情管理器
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.builder()
                .username("test")
                .password("{noop}666")
                .build();
        inMemoryUserDetailsManager.createUser(
                User.withUserDetails(userDetails)
                        .build()
        );
        return inMemoryUserDetailsManager;
    }
}
