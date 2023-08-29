package com.borrow.mapper;


import com.dazao.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {
    @Select("select * from db_borrow where uid = #{userId}")
    List<Borrow> getBorrowByUserId(@Param("userId")Integer userId);
}
