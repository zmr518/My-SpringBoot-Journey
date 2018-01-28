
SpringBoot+Mybatis+Redis+RabbitMQ+log4j2+lombok

###Redis windows安装
redis windows版本https://github.com/MicrosoftArchive/redis/releases

###RabbitMQ安装
>Windows安装
- 安装Erland，通过官方下载页面http://www.erlang.org/downloads获取exe安装包，直接打开并完成安装。
- 安装RabbitMQ，通过官方下载页面https://www.rabbitmq.com/download.html获取exe安装包。下载完成后，直接运行安装程序。
- RabbitMQ Server安装完成之后，在RabbitMQ Server\rabbitmq_server-3.7.2\sbin目录下执行rabbitmq-plugins enable rabbitmq_management命令，开启Web管理插件，这样我们就可以通过浏览器来进行管理了。
- 登录http://localhost:15672 guest/guest

###Log4j2配置，见参考资料

参考资料

[Spring Boot中使用Redis数据库](http://blog.didispace.com/springbootredis/)

[Spring Boot中使用RabbitMQ](http://blog.didispace.com/spring-boot-rabbitmq/)

[Configuring Log4J 2 using Properties File]（https://springframework.guru/log4j-2-configuration-using-properties-file/）

