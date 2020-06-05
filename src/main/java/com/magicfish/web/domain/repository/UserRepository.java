package com.magicfish.web.domain.repository;

import com.magicfish.web.domain.entity.UserEntity;

import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface UserRepository {

    @SelectProvider(type = SqlProvider.class, method = "getStatement")
    List<UserEntity> find(@Param("statement") String statement);

    @Select("select * from user where id = #{id}")
    UserEntity findById(String id);

    @Select("select * from user where username = '#{username}'")
    UserEntity findByUsername(String username);

    @UpdateProvider(type = SqlProvider.class, method = "getStatement")
    int update(@Param("statement") String statement);

    @DeleteProvider(type = SqlProvider.class, method = "getStatement")
    int delete(String id);
}
