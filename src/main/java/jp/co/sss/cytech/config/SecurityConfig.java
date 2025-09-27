package jp.co.sss.cytech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/css/**",
                    "/img/**",
                    "/js/**",
                    "/auth/register",
                    "/auth/register/submit"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/auth/login")              
                .loginProcessingUrl("/auth/login")     
                .defaultSuccessUrl("/", true)          
                .failureUrl("/auth/login?error")       
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")                        
                .logoutSuccessUrl("/auth/login?logout")      
                .invalidateHttpSession(true)                 
                .deleteCookies("JSESSIONID")                 
                .permitAll()
            );

        return http.build();
    }
}
