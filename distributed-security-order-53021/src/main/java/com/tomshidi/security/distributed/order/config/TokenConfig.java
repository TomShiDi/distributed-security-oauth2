package com.tomshidi.security.distributed.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author TomShiDi
 * @description
 * @date 2020年12月13日15:20:39
 **/
@Configuration
public class TokenConfig {

    private String ALO_KEY = "uaa123";

//    @Bean
//    public TokenStore tokenStore() {
//        return new InMemoryTokenStore();
//    }

    @Bean
    public TokenStore tokenStore() {
        // JWT令牌存储方式
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 设置对称秘钥
        converter.setSigningKey(ALO_KEY);
        return converter;
    }
}
