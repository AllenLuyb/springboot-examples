package com.example.controller;

import com.example.domain.UserEntity;
import com.example.mapper.testfirst.UserTestFirstMapper;
import com.example.mapper.testsecond.UserTestSecondMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 多数据源一般解决问题，
 * 主从模式或者业务比较复杂需要连接不同的分库支持业务
 * */
@RestController
public class UserController {

    @Autowired
    private UserTestFirstMapper userTestFirstMapper;

    @Autowired
    private UserTestSecondMapper userTestSecondMapper;

    @RequestMapping(value = "/getFirstUsers")
    public List<UserEntity> getFirstUsers(){
        return userTestFirstMapper.getAll();
    }

    @RequestMapping(value = "/getSecondUsers")
    public List<UserEntity> getSecondUsers(){
        return userTestSecondMapper.getAll();
    }

    @RequestMapping(value = "/getFirstOneUser/{id}")
    public UserEntity getFirstOneUser(@PathVariable("id") int id){
        return userTestFirstMapper.getOne(id);
    }

    @RequestMapping(value = "/getSecondOneUser/{id}")
    public UserEntity getSecondOneUser(@PathVariable("id") int id){
        return userTestSecondMapper.getOne(id);
    }
}
