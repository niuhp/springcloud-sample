package com.niuhp.springcloud.sample.actuator;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuhaipeng on 2017/3/15.
 */
@RestController
public class HelloController {
  @RequestMapping
  public String hello() {
    return "hello,world!";
  }
}
