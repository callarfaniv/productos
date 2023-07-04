/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.edu.uteq.productos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author jvillafrancacarmo
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
                .withUsername("user")
                .password(passwordEncoder().encode("123456"))
                .roles("USER")
                .build()
        );
        manager.createUser(User
                .withUsername("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN", "USER")
                .build()
        );
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> {
                    authz.requestMatchers("/").permitAll()
                            .requestMatchers("/agregar-producto/**").hasRole("USER")
                            .requestMatchers("/borrar-producto/**").hasRole("ADMIN")
                            .requestMatchers("/editar-producto/**").hasRole("ADMIN")
                            .anyRequest().authenticated();
                }
                )
                .formLogin((form) -> form
                .loginPage("/login")
                .permitAll()
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

}
