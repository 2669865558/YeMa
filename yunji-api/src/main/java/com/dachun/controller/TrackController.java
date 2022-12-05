package com.dachun.controller;

import com.dachun.dao.TrackDao;
import com.dachun.entity.Track;
import com.dachun.entity.TrackHeatMapInfo;
import com.dachun.entity.TrackInfo;
import com.dachun.entity.TrackQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className TrackController
 * @description TODO
 * @date 2022/12/6 9:55
 */
@RestController
@RequestMapping("/yunji-api/track")
@ResponseBody
public class TrackController {

    @Autowired
    private TrackDao trackDao;

    @PostMapping("/insert")
    public Integer insert(@RequestBody Track track){
        //省略校验
        return    trackDao.insert(track);
    }

    @PostMapping("/select")
    public List<TrackInfo> select(@RequestBody TrackQuery query){
        //省略校验
        return    trackDao.select(query);
    }

    @PostMapping("/heatmap/select")
    public  List<TrackHeatMapInfo> heatMapSelect(@RequestBody TrackQuery query){
        //省略校验
        return    trackDao.selectHeatMap(query);
    }

}

