package com.tk16.microservices.cart_service.infrastructure.out.web;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class BookProxyInterceptor implements RequestInterceptor {

    private final OAuth2AuthorizedClientManager clientManager;

    public BookProxyInterceptor(OAuth2AuthorizedClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Override public void apply(RequestTemplate template) {

        var token = clientManager.authorize(
                OAuth2AuthorizeRequest
                        .withClientRegistrationId("my-internal-client")
                        .principal("internal")
                        .build()
        ).getAccessToken().getTokenValue();

        template.header("Authorization", "Bearer " + token);
    }
}
