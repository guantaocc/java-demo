package com.itranswarp.learnjava.mapper;

import org.apache.ibatis.annotations.*;
import com.itranswarp.learnjava.entity.User;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getById(@Param("id") Long id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    List<User> getByUsername(@Param("username") String username);
    
    @Select("SELECT * FROM user")
    List<User> findAll();
    
    @Insert("INSERT INTO user (username, password, email, create_by, update_by, create_time, update_time) " +
           "VALUES (#{username}, #{password}, #{email}, #{createBy}, #{updateBy}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User user);
    
    @Update("UPDATE user SET username=#{username}, password=#{password}, " +
            "email=#{email}, update_by=#{updateBy}, update_time=#{updateTime} WHERE id=#{id}")
    int update(User user);
    
    @Delete("DELETE FROM user WHERE id=#{id}")
    int deleteById(@Param("id") Long id);
}
