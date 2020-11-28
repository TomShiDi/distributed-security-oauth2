package com.tomshidi.security.distributed.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author TomShiDi
 * @description
 * @date 2020/11/28 17:06
 **/
@Configuration
public class TokenConfig {

    /**
     * 令牌存储策略
     * @return TokenStore
     */
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }
}
