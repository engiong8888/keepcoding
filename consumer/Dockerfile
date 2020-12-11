FROM openjdk:8-jre-slim
MAINTAINER cheng
# 声明服务运行的端口
EXPOSE 9700

#时区配置
ENV TIME_ZONE=Asia/Phnom_Penh
RUN ln -snf /usr/share/zoneinfo/$TIME_ZONE /etc/localtime && echo $TIME_ZONE > /etc/timezone

# 将jar包复制到docker容器的/目录下
ADD target/consumer.jar /consumer.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Duser.timezone=GMT+7","-Xmx1024m","-Xms1024m","-Xss256k", "-jar", "/consumer.jar"]