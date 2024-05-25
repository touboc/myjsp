# jsp-servlet-hibernate-mysql-tutorial
User Management web application using JSP, Servlet, and Hibernate. This web application manages a collection of users with the basic feature: list, insert, update, delete (or CURD operations - Create, Update, Read and Delete).

JSP Servlet Hibernate CRUD Example - 

https://www.javaguides.net/2019/03/jsp-servlet-hibernate-crud-example.html

上面的内容，是本项目的原点。为了表达对原作者的感激，特此引用。

# 2024.05.22 改造日记
将原始程序，在以下环境下调试通过。  
Windows10，  
jdk-8u202-windows-x64.exe  
apache-tomcat-8.5.29.exe  
mysql-installer-community-8.0.37.0.msi  
eclipse-jee-2021-09-R-win32-x86_64.zip  

# 2024.05.25 机能增加日记
1，追加hot-deploy的设定manual，可以提高调试效率。
2，追加对log4j2软件包的支持，
   ※需要注意软件包匹配的重要性
   javax.servlet-api-3.1.0.jar
   log4j-web-2.10.0.jar
   log4j-api-2.10.0.jar
   log4j-core-2.10.0.jar

