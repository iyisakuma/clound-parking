package br.com.iyisakuma.parking.config;

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

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private static final String[] AUTH_WHITE_LIST = {
            "/api-docs",
            "/swagger-ui/**", "/swagger-ui.html"
    };
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(config ->{

                    config.requestMatchers(AUTH_WHITE_LIST).permitAll();
                    config.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    UserDetailsService users(){
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("dio")
                .password("teste#123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
