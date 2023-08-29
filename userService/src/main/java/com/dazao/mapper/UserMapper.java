package com.dazao.mapper;

import com.dazao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from db_user where uid = #{userId}")
    User getUserById(@Param("userId") Integer userId);
}
