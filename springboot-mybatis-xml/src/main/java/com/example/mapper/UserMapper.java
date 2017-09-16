package com.example.mapper;

import com.example.domain.UserEntity;

import java.util.List;

public interface UserMapper {
    List<UserEntity> getAll();
    UserEntity getOne(int id);
    void insertOne(UserEntity userEntity);
    void updateOne(UserEntity userEntity);
    void deleteOne(int id);
}
