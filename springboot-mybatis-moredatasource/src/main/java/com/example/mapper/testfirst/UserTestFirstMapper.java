package com.example.mapper.testfirst;

import com.example.domain.UserEntity;

import java.util.List;

public interface UserTestFirstMapper {
    List<UserEntity> getAll();
    UserEntity getOne(int id);
    void insertOne(UserEntity userEntity);
    void updateOne(UserEntity userEntity);
    void deleteOne(int id);
}