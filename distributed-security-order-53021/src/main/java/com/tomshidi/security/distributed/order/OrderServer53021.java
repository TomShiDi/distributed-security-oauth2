package com.tomshidi.security.distributed.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author TomShiDi
 * @description
 * @date 2020/11/14 21:47
 **/
@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
//@EnableFeignClients(basePackageClasses = OrderServer53021.class)
public class OrderServer53021 {
    public static void main(String[] args) {
        SpringApplication.run(OrderServer53021.class, args);
    }
}
