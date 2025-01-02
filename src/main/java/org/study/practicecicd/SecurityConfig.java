package org.study.practicecicd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) ->
                        authorizeRequests
                                .requestMatchers("/", "/**", "/practice/**").permitAll()
                );
//                .cors(cors -> {
//                    CorsConfigurationSource source = request -> {
//                        CorsConfiguration config = new CorsConfiguration();
//                        config.setAllowedOrigins(List.of("http://practice.com"));
//                        config.setAllowedMethods(List.of("GET", "POST", "OPTIONS"));
//                        return config;
//                    };
//
//                    cors.configurationSource(source);
//                });

        return http.build();
    }
}
