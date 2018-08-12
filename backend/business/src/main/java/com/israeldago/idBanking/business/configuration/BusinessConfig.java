package com.israeldago.idBanking.business.configuration;

import com.israeldago.idBanking.business.services.AuthenticationServiceImpl;
import com.israeldago.idBanking.itf.services.AuthenticationService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BusinessConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public AuthenticationService authenticationService (){
        return new AuthenticationServiceImpl();
    }
}
