# 使用官方的 OpenJDK 17 运行时镜像作为基础镜像
FROM openjdk:17-jdk-alpine

# 设置工作目录
WORKDIR /app

# 复制编译好的 Java 可执行 JAR 文件到镜像中
COPY target/Lab2-1.0-SNAPSHOT.jar /app/Lab2-1.0-SNAPSHOT.jar

# 暴露应用需要监听的端口
EXPOSE 8080

# 定义容器启动时运行的命令
CMD ["java", "-jar", "my-java-app.jar"]