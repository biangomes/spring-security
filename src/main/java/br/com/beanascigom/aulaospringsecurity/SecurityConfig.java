package br.com.beanascigom.aulaospringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // A seguranca eh feita atraves de filtros (filters)
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/public").permitAll();
            auth.requestMatchers("/logout").permitAll();
            auth.anyRequest().authenticated();
        })
        // .formLogin(Customizer.withDefaults())
        .oauth2Login(Customizer.withDefaults())
        .build();
    }
}
