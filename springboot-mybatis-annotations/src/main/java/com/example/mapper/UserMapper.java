package com.example.mapper;

import com.example.domain.UserEntity;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    @Select("select * from users")
    @Results({@Result(property = "userName",column = "user_name"),
    @Result(property = "passWord",column = "pass_word")})
    List<UserEntity> getAllUser();

    @Select("select * from users where id = #{id}")
    @Results({@Result(property = "userName",column = "user_name"),
              @Result(property = "passWord",column = "pass_word")})
    UserEntity getOneUser(int id);

    @Insert("insert into users(user_name,pass_word)values(#{userName},#{passWord})")
    void insertUser(UserEntity userEntity);

    @Update("update users set user_name = #{userName} where id = #{id}")
    void updateUsers(UserEntity userEntity);

    @Delete("delete from users where id = #{id}")
    void deleteUser(int id);
}
