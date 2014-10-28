quickstart-springmvc-mybatis
============

该框架提供基本的web访问形式。
## 视图方案主要有三种： ##

1. jspViewResolver：jsp
2. jsonViewResolver：json
3. xmlViewResolver：pdf、word、xlsx、xml、atom

## Installation ##
- 运行 classpath/resources/data/user.sql 在MySQL的test库
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

- SpringMVC 3.2.2RELEASE
- Mybatis 3.2.2
- mybatis-spring 1.2.2
- jasperreports 5.6.1

框架Client端：

- jQuery 1.11.1
- Bootstrap 3.2.0
- bootstrap-3-typeahead
- bootstrap-datepicker
- bootstrap-tagsinput
- iCheck
- jQueryFormPlugin
- sco.js-bs3
- spin.js

