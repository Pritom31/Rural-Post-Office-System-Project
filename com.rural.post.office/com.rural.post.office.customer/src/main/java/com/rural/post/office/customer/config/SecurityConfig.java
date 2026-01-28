//package com.rural.post.office.customer.config;
//
//import com.rural.post.office.customer.security.JwtAuthConverter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableMethodSecurity
//public class SecurityConfig {
//
//    @Autowired
//    JwtAuthConverter jwtAuthConverter;
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/swagger-ui/**",
//                                "/v3/api-docs/**",
//                                "/h2-console/**"
//                        ).permitAll()
//                        .anyRequest().authenticated()
//                )
//                .oauth2ResourceServer(oauth ->
//                        oauth.jwt(jwt ->
//                                jwt.jwtAuthenticationConverter(jwtAuthConverter)
//                        )
//                )
//                .headers(headers -> headers.frameOptions().disable());
//
//        return http.build();
//    }
//
//}
