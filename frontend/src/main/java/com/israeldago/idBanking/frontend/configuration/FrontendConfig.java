package com.israeldago.idBanking.frontend.configuration;

import com.israeldago.idBanking.backend.itf.services.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class FrontendConfig {

    @Bean(name = "authServiceHttpInvoker")
    public HttpInvokerProxyFactoryBean httpInvoker() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl("http://localhost:8080/authService");
        invoker.setServiceInterface(AuthenticationService.class);
        return invoker;
    }
}
