package com.dachun.controller;

import cn.hutool.core.util.ObjectUtil;
import com.dachun.dao.PersonDao;
import com.dachun.entity.Person;
import com.dachun.entity.PersonQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className PersonController
 * @description TODO
 * @date 2022/12/4 21:40
 */

@RestController
@RequestMapping("/yunji-api/person")
@ResponseBody
public class PersonController {

    @Autowired
    private PersonDao personDao;


    @PostMapping("/insert")
    public Integer insert(@RequestBody Person person){
        //省略校验
        return    personDao.insert(person);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody Person person){
        //省略校验
        return    personDao.update(person);
    }

    @GetMapping("/update/faceflag")
    public Integer update(@RequestParam String id){
        //省略校验
        return    personDao.updateFaceFlag(id);
    }

    @GetMapping("/select") // ?id=1&name=中华&pageSize=10&pageNum=3
    public PageInfo<Person> select(PersonQuery query){

        if(ObjectUtil.isNotEmpty(query.getPageNum()) && ObjectUtil.isNotEmpty(query.getPageSize())){
            PageHelper.startPage(query.getPageNum(), query.getPageSize());
        }
        List<Person> persons = personDao.select(query);

        PageInfo<Person> PageInfo = new PageInfo<Person>(persons);

        return PageInfo;
    }
    @DeleteMapping("/delete")
    public Integer delete(@RequestParam String id){
        ///校验合法性
        return   personDao.delete(id);
    }

}
