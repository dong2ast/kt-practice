package com.demo.kt;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@EnableAspectJAutoProxy
@EnableJpaAuditing
public class KtApplication {

    public static void main(String[] args) {
        SpringApplication.run(KtApplication.class, args);
    }

}
