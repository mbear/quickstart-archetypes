quickstart-springmvc-mybatis-wx-cp
============

该框架在quickstart-springmvc-mybatis框架的基础上，集成了微信企业版开发功能及jquery mobile框架。
集成了Guava Cache到Spring框架中。
系统简单实现了微信用户的登录注册功能。

## Installation ##
- 运行 classpath/resources/data/的sql文件：user为用户表，wx_cp_config为微信企业号属性配置。
- 修改数据库连接配置 classpath/resources/application.properties

## 运行 ##

- 项目起始路径：http://localhost:8080/contextPath/
- jsp页面形式访问：http://localhost:8080/contextPath/welcome
- json形式访问：http://localhost:8080/contextPath/users
- pdf形式访问：http://localhost:8080/contextPath/pdf/sample.pdf

## 框架介绍 ##

Java 版本

- 1.7

框架Server端：

- SpringMVC 4.1.1RELEASE
- Mybatis 3.2.2
- mybatis-spring 1.2.2
- jasperreports 5.6.1

框架Client端：

- jQuery 1.11.1
- jQuery Mobile 1.4.4

微信Server端

- 后台api，特别感谢[chanjarster](https://github.com/chanjarster/weixin-java-tools)

微信client端

- 前台js，特别感谢[zxlie/WeixinApi](https://github.com/zxlie/WeixinApi)