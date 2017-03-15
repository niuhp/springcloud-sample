package com.niuhp.springcloud.sample.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by niuhaipeng on 2017/3/15.
 */
@RestController
public class HelloZhController {
  @RequestMapping("zh")
  public String hello() {
    return "世界，你好！";
  }
}
