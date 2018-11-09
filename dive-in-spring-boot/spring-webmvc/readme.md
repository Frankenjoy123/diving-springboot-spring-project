
## 启动步骤
1. `cd spring-webmvc`
1. `mvn clean package`
2. `java -jar  target\spring-webmvc-0.0.1-SNAPSHOT-war-exec.jar`


## 注意引入servlet-api jstl**
```
        <!--Servlet 3.1依赖-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>

        <!--jstl依赖-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
```

## 启动远程调试

调试端口为5000
```
java -agentlib:jdwp=transport=dt_socket,address=5000,suspend=n,server=y -jar  target/spring-webmvc-0.0.1-SNAPSHOT-war-exec.jar
```