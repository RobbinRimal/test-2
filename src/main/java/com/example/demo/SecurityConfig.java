package com.example.demo;

import com.example.demo.services.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    @Deprecated
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        List<UserDetails> usersList = new ArrayList<>();
//        usersList.add(new User(
//                "buzz", encoder.encode("password"),
//                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        usersList.add(new User(
//                "woody", encoder.encode("password"),
//                Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
//        return new InMemoryUserDetailsManager(usersList);
//    }

    @Bean

    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            UserInfo user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
//                        .requestMatchers("/admin"). hasAnyRole("ADMIN")
//                        .requestMatchers("/user"). hasAnyRole( "USER")
//                        .requestMatchers("/h2-console") .anonymous()
//                        .requestMatchers("/h2-console/**") .permitAll()
                        .requestMatchers("/", "/**") .permitAll()
                        .anyRequest().authenticated()

                );
//                .formLogin(form -> form
//                     .loginPage("/register")
//                .usernameParameter("user")
//                .passwordParameter("pwd")
//                )
//                .logout(logout -> logout
//                        .permitAll());





        return http.build();
    }
}