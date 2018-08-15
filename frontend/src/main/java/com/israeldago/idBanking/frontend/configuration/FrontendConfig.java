package com.israeldago.idBanking.frontend.configuration;

import com.israeldago.idBanking.backend.itf.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@PropertySource("classpath:presentation.properties")
public class FrontendConfig {

    @Autowired
    private Environment env;

    @Value("${remoting.authentication.url}")
    private String backendAuthServiceUrl;

    @Bean(name = "authServiceHttpInvoker")
    HttpInvokerProxyFactoryBean httpInvoker() {
        HttpInvokerProxyFactoryBean invoker = new HttpInvokerProxyFactoryBean();
        invoker.setServiceUrl(backendAuthServiceUrl);
        invoker.setServiceInterface(AuthenticationService.class);
        return invoker;
    }

    @Bean
    @ConfigurationProperties("view.resolver")
    ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(env.getProperty("prefix"));
        resolver.setSuffix(env.getProperty("suffix"));
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
