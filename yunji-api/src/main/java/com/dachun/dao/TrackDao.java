package com.dachun.dao;

import com.dachun.entity.Track;
import com.dachun.entity.TrackHeatMapInfo;
import com.dachun.entity.TrackInfo;
import com.dachun.entity.TrackQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrackDao {
    @Insert("insert a_track (personId,venueId) values (#{personId},#{venueId})")
    int insert(Track track);

    @Select("<script> select   cast(t.time as date) as day , v.name,   count(1) as count \n" +
            " from a_track  t " +
            " left join a_venue v " +
            " on t.venueId  = v.id " +
            " where 1 = 1 " +
            " <if test='startDate != null and endDate != null '> " +
            " and t.time between #{startDate} and #{endDate}  " +
            " </if> " +
            " <if test='venueIds != null '> " +
            " and venueId in " +
            " <foreach collection='venueIds' item='a' open='(' close=')' separator=','> " +
            "     #{a}   " +
            " </foreach>" +
            " </if> " +
            " group by  cast(t.time as date),v.name order by day" +
            "</script> ")
    List<TrackInfo> select(TrackQuery query);


    @Select("<script> select v.lat,v.lng, count(t.personId) as count " +
            " from  a_venue v " +
            " inner join a_track t  " +
            " on v.id = t.venueId " +
            " where 1 = 1 " +
            " <if test='startDate != null and endDate != null '> " +
            " and t.time between #{startDate} and #{endDate}  " +
            " </if> " +
            " <if test='venueIds != null '> " +
            " and venueId in " +
            " <foreach collection='venueIds' item='a' open='(' close=')' separator=','> " +
            "     #{a}   " +
            " </foreach>" +
            " </if> " +
            " group by v.id " +
            "</script> ")
    List<TrackHeatMapInfo> selectHeatMap(TrackQuery query);
}
