package com.dachun.dao;


import com.dachun.entity.Person;
import com.dachun.entity.PersonQuery;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonDao {

    @Insert(" insert into a_person (id,name,phone,address,venueId) values " +
            " (#{id},#{name},#{phone},#{address},#{venueId}) ")
    int insert(Person person);

    @Update(" update a_person set name = #{name}, phone = #{phone}, address = #{address}," +
            " venueId = #{venueId} " +
            " where id = #{id}")
    int update(Person venue);

    @Select("<script> select  *  from  a_person" +
            " where 1 = 1 " +
            " <if test = 'id != null'> " +
            " and id = #{id} " +
            "</if>" +
            " <if test = 'name != null'> " +
            " and name like concat ('%',trim(#{name}),'%') " +
            "</if>" +
            " <if test = 'phone != null'> " +
            " and phone = #{phone} " +
            "</if>" +
            " <if test = 'venueId != null'> " +
            " and venueId = #{venueId} " +
            "</if>" +
            "</script>")
    List<Person> select(PersonQuery query);


    @Update(" update a_person set faceFlag = 1 " +
            " where id = #{id}")
    int updateFaceFlag(String id);

    @Delete(" delete from a_person where id = #{id}")
    int delete(String id);

}