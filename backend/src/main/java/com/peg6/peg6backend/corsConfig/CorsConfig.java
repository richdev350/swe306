package com.peg6.peg6backend.corsConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").
                        allowedOrigins("http://localhost","https://swe-306-final-project.vercel.app"). //allow all
                        allowedMethods("*"). //post, get, .etc
                        allowedHeaders("*"). //allow any header
                        allowCredentials(true). //with cookie
                        exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L); //
            }
        };
    }
}

