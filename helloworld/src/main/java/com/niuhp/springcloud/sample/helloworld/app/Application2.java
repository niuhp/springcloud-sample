package com.niuhp.springcloud.sample.helloworld.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by niuhaipeng on 2017/3/15.
 */
@SpringBootApplication
@ComponentScan("com.niuhp.springcloud.sample.helloworld")
public class Application2 {
  public static void main(String[] args) {
    SpringApplication.run(Application2.class, "--server.port=8081");
  }
}
