package com.tomshidi.security.distributed.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author TomShiDi
 * @description
 * @date 2020年12月19日16:34:38
 **/
@Configuration
public class ResourceServerConfig {

    public static final String RESOURCE_ID = "res1";


    @Configuration
    @EnableResourceServer
    public class UAAServerConfig extends ResourceServerConfigurerAdapter {

        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID)
                    // 令牌验证
                    .tokenStore(tokenStore)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/uaa/**").permitAll();
        }
    }

    @Configuration
    @EnableResourceServer
    public class OrderServerConfig extends ResourceServerConfigurerAdapter {
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources.resourceId(RESOURCE_ID)
                    // 令牌验证
                    .tokenStore(tokenStore)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/order/**").access("#oauth2.hasScope('ROLE_API')");
        }
    }

}
