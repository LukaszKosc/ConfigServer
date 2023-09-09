package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    /*
     *   - no authentication at all for encrypt/decrypt endpoints (or any other)
     *   - disabled csrf
     */
//    Working code - with disabling CSRF for encrypt/decrypt - and no authentication at all
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(httpSecurityCsrfConfigurer ->
                httpSecurityCsrfConfigurer
                        .ignoringRequestMatchers("/encrypt/**")
                        .ignoringRequestMatchers("/decrypt/**")
        );
        return http.build();
    }
}
