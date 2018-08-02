# spirngcloud  

使用了springboot spring-data-jpa redis elasticsearch（2.4.6） vue.js  element-ui

zsk-app  消费者，端口 8021

zsk-commons 公共包

zsk-dao  数据包

zsk-ddo  jpa实体

zsk-dvo  消费端实体

zsk-eureka  注册中心  端口8001

zsk-service  服务端   端口8011

需要启动3个服务

启动顺序zsk-eureka -> zsk-service -> zsk-app


启动方式
1、可以直接用eclipse启动，开发环境

2、打成jar包，java -jar  xxx.jar 命令启动

关闭命令

#启用shutdown

endpoints.shutdown.enabled=true

#禁用密码验证

endpoints.shutdown.sensitive=false

curl -X POST http://localhost:8080/shutdown

安全验证

如果在关闭时需要安全验证，则在pom.xml文件中添加：
<dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-security</artifactId>
</dependency>

application.properties中添加：

#开启shutdown的安全验证

endpoints.shutdown.sensitive=true

#验证用户名

security.user.name=admin

#验证密码

security.user.password=admin

#角色

management.security.role=SUPERUSER

# 指定端口

management.port=8081

# 指定地址

management.address=127.0.0.1

关闭命令为：

curl -u admin:admin -X POST http://127.0.0.1:8081/manage/shutdown

