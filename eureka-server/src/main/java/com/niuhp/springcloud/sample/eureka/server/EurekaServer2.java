package com.niuhp.springcloud.sample.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by niuhaipeng on 2017/3/15.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer2 {
  public static void main(String[] args) {
    SpringApplication.run(EurekaServer2.class, "--spring.profiles.active=peer2");
  }
}
