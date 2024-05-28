package ch.fhnw.webec.exercise.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authz -> authz
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
            .requestMatchers("/error").permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/about").permitAll()
            .requestMatchers("/register").permitAll()
            .requestMatchers("/category").permitAll()
            .requestMatchers("/user/").permitAll()
            .requestMatchers("/user/{id}").permitAll()
            .requestMatchers("/profile").permitAll()
            .anyRequest().authenticated()
        ).formLogin(form -> form
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/")
        ).csrf(csrf -> csrf
            .ignoringRequestMatchers("/api/**") // Ignoring for demonstrating purposes only!
        ).build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
