package com.israeldago.idBanking.frontend;

import com.israeldago.idBanking.frontend.configuration.FrontendConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(FrontendConfig.class)
public class PresentationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(PresentationLauncher.class, args);
    }
}
