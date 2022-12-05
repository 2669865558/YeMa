package com.dachun.dao;

import com.dachun.entity.TuKu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TuKuDao {

    @Insert("insert into a_tuku (name,img) values (#{name},#{img})")
    int insert(TuKu tuKu);

    @Select(" select  *  from a_tuku")
    List<TuKu> select();
}
