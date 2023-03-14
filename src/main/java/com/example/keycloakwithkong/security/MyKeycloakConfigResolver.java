package com.example.keycloakwithkong.security;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.representations.adapters.config.AdapterConfig;


public class MyKeycloakConfigResolver implements KeycloakConfigResolver{

    private KeycloakDeployment keycloakDeployment;

    public MyKeycloakConfigResolver(String realm, String clientId, String authServerUrl) {
        AdapterConfig adapterConfig = new AdapterConfig();
        adapterConfig.setRealm(realm);
        adapterConfig.setResource(clientId);
        adapterConfig.setAuthServerUrl(authServerUrl);
        this.keycloakDeployment = KeycloakDeploymentBuilder.build(adapterConfig);
    }

    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
        return keycloakDeployment;
    }
}
