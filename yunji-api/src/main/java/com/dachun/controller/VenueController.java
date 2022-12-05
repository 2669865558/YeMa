package com.dachun.controller;

import cn.hutool.core.util.ObjectUtil;
import com.dachun.dao.VenueDao;
import com.dachun.entity.Venue;
import com.dachun.entity.VenueQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className VenueController
 * @description TODO
 * @date 2022/12/1 9:26
 */
@RestController
@ResponseBody
@RequestMapping("/yunji-api/venue")
public class VenueController {

    @Autowired
    private VenueDao venueDao;

    @PutMapping("/update")
    public Integer update(@RequestBody Venue venue) {
        //省略校验
        return venueDao.update(venue);
    }

    @PostMapping("/insert")
    public Integer insert(@RequestBody Venue venue) {
        //省略校验
        return venueDao.insert(venue);
    }

//    @GetMapping("/select")
    @GetMapping("/select")
    public PageInfo<Venue> select(VenueQuery query) {
        if (ObjectUtil.isNotEmpty(query.getPageNum()) && ObjectUtil.isNotEmpty(query.getPageSize())) {
            PageHelper.startPage(query.getPageNum(), query.getPageSize());
        }
        return new PageInfo<>(venueDao.select(query));
    }

    @GetMapping("/select1")
    public PageInfo<Venue> select1(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageSize,pageNum);
        List<Venue> venues = venueDao.select1();
        PageInfo<Venue> pageInfo1 = new PageInfo<Venue>(venues);
        return pageInfo1;
    }

    @GetMapping("select2")
    public Venue selectById(int id){
        return venueDao.selecyById(id);
    }






    @GetMapping("/delete")
    public Integer delete(@RequestParam Integer id) {
        ///校验合法性
        return venueDao.delete(id);
    }
}

