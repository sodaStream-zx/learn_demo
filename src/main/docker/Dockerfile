FROM java:8
MAINTAINER Dava-J <398414828>@qq.com>
ENV TZ=Asia/Shanghai
#将当前目录中的 name.jar 复制到容器根目录中
ADD zxxLearn.jar /app.jar

#运行命令
#RUN chmod 777 -R /nacos
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime
#开放端口
#EXPOSE 8848
#ENTRYPOINT ["sh","/nacos/bin/startup.sh","-m","standalone","&"]
#启动运行命令
ENTRYPOINT ["java","-jar","/app.jar","&"]

