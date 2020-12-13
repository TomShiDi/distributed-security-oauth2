package com.tomshidi.security.distributed.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author TomShiDi
 * @description
 * @date 2020/12/13 17:16
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GatewayServer53010 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServer53010.class, args);
    }
}
