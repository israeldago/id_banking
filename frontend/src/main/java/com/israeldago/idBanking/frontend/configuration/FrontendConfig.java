package com.israeldago.idBanking.frontend.configuration;

import com.israeldago.idBanking.backend.itf.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
@PropertySource("classpath:presentation.properties")
public class FrontendConfig {

    @Value("${remoting.authentication.url}")
    private String backendAuthServiceUrl;

    @Bean(name = "authServiceHttpInvoker")
    public HttpInvokerProxyFactoryBean httpInvoker() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(backendAuthServiceUrl);
        invoker.setServiceInterface(AuthenticationService.class);
        return invoker;
    }
}
