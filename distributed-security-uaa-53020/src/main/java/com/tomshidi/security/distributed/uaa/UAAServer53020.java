package com.tomshidi.security.distributed.uaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author TomShiDi
 * @description
 * @date 2020/11/14 21:11
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackageClasses = UAAServer53020.class)
//@EnableHystrix
//@EnableFeignClients(basePackageClasses = UAAServer53020.class)
public class UAAServer53020 {
    public static void main(String[] args) {
        SpringApplication.run(UAAServer53020.class, args);
    }
}
