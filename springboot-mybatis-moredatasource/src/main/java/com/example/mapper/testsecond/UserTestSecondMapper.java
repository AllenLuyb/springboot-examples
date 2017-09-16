package com.example.mapper.testsecond;

import com.example.domain.UserEntity;

import java.util.List;


public interface UserTestSecondMapper {
    List<UserEntity> getAll();
    UserEntity getOne(int id);
    void insertOne(UserEntity userEntity);
    void updateOne(UserEntity userEntity);
    void deleteOne(int id);
}