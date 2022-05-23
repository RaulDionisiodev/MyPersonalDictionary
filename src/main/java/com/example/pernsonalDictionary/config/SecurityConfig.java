package com.example.pernsonalDictionary.config;

import com.example.pernsonalDictionary.service.CustonUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.example.pernsonalDictionary.config.SecurityConstants.NEW_USER_URL;
import static com.example.pernsonalDictionary.config.SecurityConstants.SIGN_UP_URL;

@EnableWebSecurity
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustonUserDetailsService custonUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                        .antMatchers(HttpMethod.GET, SIGN_UP_URL).permitAll()
                        .antMatchers(HttpMethod.PUT, NEW_USER_URL).permitAll()
                        .anyRequest().authenticated()
                        .and()
                        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                        .addFilter(new JWTAuthenticationFilter(authenticationManager(), custonUserDetailsService))
                        .addFilter(new JWTAuthorizationFilter(authenticationManager(), custonUserDetailsService));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(custonUserDetailsService).passwordEncoder( new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/h2-console/**");
    }
}
