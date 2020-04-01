package pri.zxx.webdemo.aops;

import pri.zxx.webdemo.annotation.ExtParam;
import pri.zxx.webdemo.annotation.InsertMysql;
import pri.zxx.webdemo.annotation.SelectMysql;

public interface UserMapper {

    @InsertMysql(value = "insert into user (name, age)values(#{name},#{age})")
    int addUser(@ExtParam("name") String name, @ExtParam("age") int age);

    @SelectMysql("select * from user where name=#{name}")
    User query(@ExtParam("name") String name);
}