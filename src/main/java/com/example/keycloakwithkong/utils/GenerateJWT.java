package com.example.keycloakwithkong.utils;

import lombok.RequiredArgsConstructor;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenerateJWT {

    @Value("${spring.keycloak.realm}")
    private String realmName;

    @Value("${spring.keycloak.serverUrl}")
    private String serverUrl;

    @Value("${spring.keycloak.clientId}")
    private String clientId;

    @Value("${spring.keycloak.clientSecret}")
    private String clientSecret;

    public String getToken(){
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl("MyRealm")
                .realm("http://localhost:8083/auth")
                .clientId("spring-gateway-app")
                .clientSecret("6166726f-6b12-4fae-a9a9-9835ac82a24f")
                .username("hieupm")
                .password("1234")
                .build();

        String accessToken = null;
        try {
            AccessTokenResponse tokenResponse = keycloak.tokenManager().getAccessToken();
            accessToken = tokenResponse.getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessToken;
    }

}
