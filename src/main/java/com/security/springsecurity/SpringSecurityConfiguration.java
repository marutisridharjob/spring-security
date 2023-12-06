package com.security.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.authorizeRequests(req -> req
                        // '/demo' routing to login page. '/demo/one' skips login page. '/demo/two' & 'demo/three' need authentication.
                        .requestMatchers("/demo", "/demo/one")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    /**
     * In Memory User Demo
     */
    @Bean
    public UserDetailsService userDetailsManager() {

        User.UserBuilder users = User.withDefaultPasswordEncoder();

        UserDetails admin = users
                .username("uOne")
                .password("pOne")
                .roles("USER")
                .build();

        UserDetails user0 = users
                .username("uTwo")
                .password("pTwo")
                .roles("USER")
                .build();

        UserDetails user1 = users
                .username("uThree")
                .password("pThree")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user0, user1);
    }

}
