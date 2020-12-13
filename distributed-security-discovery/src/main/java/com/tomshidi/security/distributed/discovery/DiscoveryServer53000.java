package com.tomshidi.security.distributed.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TomShiDi
 * @description
 * @date 2020/12/13 16:42
 **/
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServer53000 {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServer53000.class, args);
    }
}
