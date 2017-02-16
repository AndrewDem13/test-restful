package com.demyanenko.core;

import com.demyanenko.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(User.PASSWORD_ENCODER);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                /** Feature below is for testing, NOT for production **/
                .and()
                .csrf().disable();
        http.authorizeRequests().antMatchers("/", "/articles", "/articles/{id}", "/articles/{id}/comments", "/articles/{id}/author",
                "/comments", "/comments/{id}","/comments/{id}/article", "/comments/{id}/author").permitAll().anyRequest().authenticated()
                .and().
                authorizeRequests().antMatchers("/users").permitAll().anyRequest().hasRole("ADMIN");
    }
}
