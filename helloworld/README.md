这篇文章主要介绍怎么使用[Spring Boot](http://projects.spring.io/spring-boot/)快速创建一个web项目。

## 快速开始

### 增加maven配置

``` xml
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.1.RELEASE</version>
    </parent>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
    
    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

```

详情: [pom.xml](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/pom.xml)

### 创建controller

``` java
@RestController
public class HelloController {
  @RequestMapping
  public String hello() {
    return "hello,world!";
  }
}
```

详情: [HelloController.java](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/controller/HelloController.java)

### 创建启动类

``` java
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
```

详情: [Application.java](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/Application.java)

### 运行

直接运行main方法，在浏览器打开[http://127.0.0.1:8080/](http://127.0.0.1:8080/)即可看到结果

![](http://img.niuhp.com/springcloud/helloworld/helloworld.png)

## 思考
**1. 开发一个web项目真的只需要这么少的依赖吗？**  
当然不是。在pom文件上按下*ctrl+alt+shift+u*(idea项目)你会发现，我们的web项目其实是[Spring Boot](http://projects.spring.io/spring-boot/)帮我们集成了springmvc和tomcat。  
![](http://img.niuhp.com/springcloud/helloworld/diagram.png)
**2. Application是如何扫描到我的controller的？** 
打开*SpringBootApplication*注解的源码可以看到它上面有个*ComponentScan*注解，也就是会扫描*Application*当前包及其子包下的spring组件
``` java
@ComponentScan(
  excludeFilters = {@Filter(
  type = FilterType.CUSTOM,
  classes = {TypeExcludeFilter.class}
), @Filter(
  type = FilterType.CUSTOM,
  classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication 
```
这点我们可以通过再写一个启动类[Application2.java](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/app/Application2.java)来验证。  
在*Application2*上不加*ComponentScan*注解的情况下，运行程序将加载不到任何controller（因为app包下没有），而加上
``` java
@ComponentScan("com.niuhp.springcloud.sample.helloworld")
``` 
就可以加载到[HelloController](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/controller/HelloController.java)和[HelloZhController](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/HelloZhController.java)  
但如果是
``` java
@ComponentScan("com.niuhp.springcloud.sample.helloworld.controller")
``` 
则只能加载到[HelloController](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/controller/HelloController.java)了  
**3. 如何指定端口？**  
我们只需要在java启动程序传入参数或者直接修改main方法参数就可以了，[Spring Boot](http://projects.spring.io/spring-boot/)支持各种自定义参数，这里不再重复，以后找机会详细介绍。
``` java
--server.port=自定义端口号
``` 

**本文代码位置：**[helloworld](https://github.com/niuhp/springcloud-sample/tree/master/helloworld)