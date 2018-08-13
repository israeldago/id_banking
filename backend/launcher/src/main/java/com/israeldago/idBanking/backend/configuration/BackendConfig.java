package com.israeldago.idBanking.backend.configuration;

import com.israeldago.idBanking.backend.business.services.AuthenticationServiceImpl;
import com.israeldago.idBanking.backend.dao.repositories.UsersRepository;
import com.israeldago.idBanking.backend.itf.mappers.UserMapper;
import com.israeldago.idBanking.backend.itf.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;

@Configuration
public class BackendConfig {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private UserMapper userMapper;
    @Value("${users.api}")
    private String usersApi;

    @Bean(name = "/authService")
    public HttpInvokerServiceExporter authenticationServiceExporter(){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(AuthenticationService.class);
        exporter.setService(new AuthenticationServiceImpl(usersRepository, restTemplateBuilder.build(), userMapper, usersApi));
        return exporter;
    }
}
