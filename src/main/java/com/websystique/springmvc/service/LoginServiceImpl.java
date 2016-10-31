package com.websystique.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Service;

/**
 * Created by Yaroslav on 26.10.2016.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    TokenStore tokenStore;

    @Override
    public String getUserLogin(String access_token) {
        OAuth2Authentication authentication = tokenStore.readAuthentication(access_token);
        if (authentication == null) {
            throw new InvalidTokenException("Invalid access token: " + access_token);
        }
        OAuth2Request clientAuth = authentication.getOAuth2Request();
        if (clientAuth == null) {
            throw new InvalidTokenException("Invalid access token (no client id): " + access_token);
        }
        return authentication.getName();

    }
}
