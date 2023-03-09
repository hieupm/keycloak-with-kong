package com.example.keycloakwithkong.Controller;

import com.example.keycloakwithkong.utils.GenerateJWT;
import com.nimbusds.openid.connect.sdk.claims.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final GenerateJWT generateJWT;

    @Value("${spring.keycloak.realm}")
    private String realmName;
    @GetMapping("/user")
    public String index(Principal principal){
        return "User's Keycloak ID: " + principal.getName();
    }

    @GetMapping("/generate-jwt")
    public String generateToken(){
        return generateJWT.getToken();
    }
}
