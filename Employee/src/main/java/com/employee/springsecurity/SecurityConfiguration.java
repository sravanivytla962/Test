package com.employee.springsecurity;

import org.springframework.context.annotation.Configuration;  
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;  
import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;  
@Configuration  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {  
    @Override  
    public void configure(HttpSecurity http) throws Exception {  
        http  
            .authorizeRequests()  
            .anyRequest().authenticated()  
            .and()  
            .httpBasic();  
    }  
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
        auth.inMemoryAuthentication()  
            .withUser("user")  
            .password("user"); // Spring Security 5 requires specifying the password storage format  
            
    }  
}
