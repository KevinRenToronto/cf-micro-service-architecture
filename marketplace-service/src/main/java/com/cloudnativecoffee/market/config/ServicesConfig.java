package com.cloudnativecoffee.market.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableOAuth2Client
public class ServicesConfig {

	@Bean(name="oauthRestTemplate")
	@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	OAuth2RestTemplate restTemplateOAuth(OAuth2ProtectedResourceDetails resource, OAuth2ClientContext context) {
		return new OAuth2RestTemplate(resource, context);
	}
	
	@Bean(name="restTemplate")
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


}
