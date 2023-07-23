package com.example.app_bank1.account;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configures Spring Security for the application.
     *
     * @param http The HttpSecurity object used to configure security.
     * @return The SecurityFilterChain containing security configurations.
     * @throws Exception If an error occurs during the configuration.
     */
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // Disable CSRF protection (Cross-Site Request Forgery) for simplicity.
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    /**
     * Configures the authorization rules for different types of requests.
     *
     * @param auth The HttpSecurityDsl.AuthorizeHttpRequestsDsl used to configure authorization.
     * @throws Exception If an error occurs during the configuration.
     */
    private void configureAuthorization(AuthorizeHttpRequestsDsl auth) throws Exception {
        // Permit all types of requests (GET, POST, PUT, DELETE, etc.) without any restrictions.
        auth.anyRequest().permitAll();
    }
}
