# tlias-web-management
demo from itheima

To run this project, you should create a configuration file named **application.yml** in the */src/main/resources* directory. The structure of the configuration file should be as follows:

``` yml
spring:
    datasource:
        driver-class-name: com.mysql.cj.jdbc.Driver
        url: jdbc:mysql://localhost:3306/(your database name)
        username: (your username)
        password: (your password)
    servlet:
        multipart:
            max-file-size: 10MB         # modify the maximum upload limit for a single file
            max-request-size: 100MB     # modify the maximum upload limit for a single request

mybatis:
    configuration:
        log-impl: org.apache.ibatis.logging.stdout.StdOutImpl   # Configure MyBatis logging, specify output to console.
        map-underscore-to-camel-case: true                      # Enable the automatic mapping switch for MyBatis's camel case naming: a_column ------> aCloumn.

aliyun:
    oss:
        endpoint: (your aliyunOSS endpoint, for example: https://oss-cn-beijing.aliyuncs.com)
        accessKeyId: (your aliyunOSS accessKeyId)
        accessKeySecret: (your aliyunOSS accessKeySecret)
        bucketName: (your aliyunOSS bucketName)

```