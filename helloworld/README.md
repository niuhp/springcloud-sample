
本文主要介绍怎么使用[Spring Cloud](http://projects.spring.io/spring-cloud/) 快速创建一个 restful 服务，原文链接 [springcloud 构建微服务 01 — 创建 restful 服务](https://niuhp.com/springcloud/01-helloworld.html)。

### 1 创建 maven 项目

参考[官方示例](http://projects.spring.io/spring-cloud/#quick-start)，在 [pom.xml](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/pom.xml) 中添加配置：

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.0.0.M7</version>
</parent>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Finchley.M7</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
<dependencies>
    <dependency>
        <groupId></groupId>
        <artifactId>spring-cloud-starter-config</artifactId>
    </dependency>
    <dependency>
        <groupId></groupId>
        <artifactId>spring-cloud-starter-eureka</artifactId>
    </dependency>
</dependencies><repositories>
    <repository>
        <id>spring-milestones</id>
        <name>Spring Milestones</name>
        <url>https://repo.spring.io/libs-milestone</url>
        <snapshots>
            <enabled>false</enabled>
        </snapshots>
    </repository>
</repositories>
```

### 2 创建 controller

简单几行代码即可创建 [HelloController](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/HelloController.java)  

```java
@RestController
public class HelloController {
  @RequestMapping
  public String hello() {
    return "hello,world!";
  }
}
```

### 3 创建启动类
启动类 [Application](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/Application.java) 的代码也很简单：  

``` java
@SpringBootApplication
public class Application {
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
```

### 4 运行

直接运行 启动类 [Application](https://github.com/niuhp/springcloud-sample/blob/master/helloworld/src/main/java/com/niuhp/springcloud/sample/helloworld/Application.java) 的 main 方法，在浏览器打开 [http://127.0.0.1:8080/](http://127.0.0.1:8080/) 即可看到结果

![](//s.niuhp.com/blog/springclooud/helloworld.png)

### 5 注意
- 应用默认扫描被注解 `@SpringBootApplication` 标记的类所在包及其子包下的 class ，可以通过注解的 `basePackages` 属性定制扫描基础包
- 应用默认监听 8080 端口，可以通过 `--server.port=your_port` 指定，如在 `application.yml` 里增加一行 `server.port: 8888` 或在应用启动时指定控制台参数 `--server.port=8888` 即监听 8888 端口。
