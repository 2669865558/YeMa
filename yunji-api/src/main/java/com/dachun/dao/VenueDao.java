package com.dachun.dao;

import com.dachun.entity.Venue;
import com.dachun.entity.VenueQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueDao {
    @Insert(" insert into a_venue (name,img,province,city,country,address,lng,lat,brief,seq) values " +
            " (#{name},#{img},#{province},#{city},#{country},#{address},#{lng},#{lat},#{brief},#{seq}) ")
    int insert(Venue venue);

    @Update(" update a_venue set name = #{name} ,img = #{img},province = #{province},city = #{city}," +
            "country = #{country},address = #{address},lng = #{lng},lat = #{lat}," +
            " brief = #{brief},seq = #{seq} where id = #{id}")
    int update(Venue venue);

    @Select("<script> select  *  from  a_venue" +
            " where 1 = 1 " +
            " <if test = 'id != null'> " +
            " and id = #{id} " +
            "</if>" +
            " <if test = 'name != null'> " +
            " and name like concat ('%',#{name},'%') " +
            "</if>" +
            " <if test = 'country != null'> " +
            " and country = #{country} " +
            "</if>" +
            "</script>")
    List<Venue> select(VenueQuery query);

    @Select("select * from a_venue")
    List<Venue> select1();


    @Delete(" delete from a_venue where id = #{id}")
    int delete(Integer id);

    @Select(" select * from a_venue where id = #{id}")
    Venue selecyById(Integer id);
}

