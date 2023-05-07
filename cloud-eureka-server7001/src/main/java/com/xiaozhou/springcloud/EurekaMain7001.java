package com.xiaozhou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>
 *   TODO
 * </P>
 *
 * @date: 2023/5/7
 * @author: xz
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer //Eureka服务
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
