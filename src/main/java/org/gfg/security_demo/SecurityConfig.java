package org.gfg.security_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig{

    @Bean
    JdbcUserDetailsManager users(DataSource dataSource) {
        UserDetails developer = User.builder()
                .username("developer")
                .password("$2a$10$PVeAPzqdZgSuLPBLklttdewPcurZk69Pr5vmf9HVDrx8gAp6PGYY6")
                .roles("DEVELOPER")
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$mrKQj1.6gSRoFG/srSazrOKwnv7LKIRm5CMMoxh.zmsVSaU3aM08a")
                .roles("ADMIN")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(developer);
        users.createUser(admin);
        return users;
    }

    //    Authentication
//    @Bean
//    public UserDetailsManager userDetailsService() {
//        UserDetails user = User.builder()
//                .username("developer")
//                .password("$2a$10$PVeAPzqdZgSuLPBLklttdewPcurZk69Pr5vmf9HVDrx8gAp6PGYY6")
//                .roles("DEVELOPER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("$2a$10$mrKQj1.6gSRoFG/srSazrOKwnv7LKIRm5CMMoxh.zmsVSaU3aM08a")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
    //Authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/developer/**").hasRole("DEVELOPER")
                        .requestMatchers("/home/**").permitAll()
                        .requestMatchers("/tester/**").hasAnyRole("DEVELOPER", "ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                ).formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder getEncoder(){
        return new BCryptPasswordEncoder();
    }
}

