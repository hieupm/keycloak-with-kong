package com.example.keycloakwithkong.Controller;

import lombok.RequiredArgsConstructor;
import org.keycloak.KeycloakPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.keycloak.KeycloakSecurityContext;
import javax.servlet.http.HttpServletRequest;


@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/protected-resource")
    public ResponseEntity<String> getProtectedResource(Authentication authentication) {
        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) authentication.getPrincipal();
        KeycloakSecurityContext keycloakSecurityContext = keycloakPrincipal.getKeycloakSecurityContext();
        String accessTokenString = keycloakSecurityContext.getTokenString();
        return ResponseEntity.ok("Hello, you have successfully authenticated with JWT token: " + accessTokenString);
    }

}
