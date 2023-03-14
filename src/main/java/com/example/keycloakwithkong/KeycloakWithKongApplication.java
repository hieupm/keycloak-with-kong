package com.example.keycloakwithkong;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(KeycloakSpringBootConfigResolver.class)
@KeycloakConfiguration
public class KeycloakWithKongApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeycloakWithKongApplication.class, args);
    }

}
