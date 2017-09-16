package com.example.controller;

import com.example.domain.UserEntity;
import com.example.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/getAllUser")
    public List<UserEntity> getUsers(){
        return userMapper.getAllUser();
    }

    @RequestMapping(value = "/getOneUser")
    public UserEntity getOneUser(int id){
        return userMapper.getOneUser(id);
    }

    @RequestMapping(value = "/insertUser")
    public void insertUser(String userName,String passWord){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("zhangsan");
        userEntity.setPassWord("123456");
        userMapper.insertUser(userEntity);
    }

    @RequestMapping(value = "/updateUser")
    public void updateUser(String userName,int id){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("zhangsan1");
        userEntity.setId(1);
        userMapper.updateUsers(userEntity);
    }

    /*如果使用"/{id}"写法，就必须使用PathVariable进行绑定否则报错。
    * 使用PathVariable来制定url路径中的变量，直接使用此调用方法即可
    * url/id(id代表要传的内容，针对此方法举例)*/
    @RequestMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userMapper.deleteUser(id);
    }
}
