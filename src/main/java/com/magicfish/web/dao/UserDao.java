package com.magicfish.web.dao;

import com.magicfish.web.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from  user where username = #{username}")
    User findByUsername(String username);

    @Select("select * from  user where id = #{id}")
    User findById(String id);

//    List<User> selectUsers();
}
