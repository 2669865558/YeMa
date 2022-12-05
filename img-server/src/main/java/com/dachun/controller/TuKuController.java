package com.dachun.controller;

import cn.hutool.core.codec.Base64Decoder;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.dachun.dao.TuKuDao;
import com.dachun.entity.TuKu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @className TuKuController
 * @description TODO
 * @date 2022/11/29 19:33
 */
@RestController
@ResponseBody
@RequestMapping("/imgserver-api")
public class TuKuController {

    @Value("${web.imageUse}")
    private String baseUploadPath;

    @Autowired
    private TuKuDao tuKuDao;

    @RequestMapping("/select")
    public List<TuKu> select(){
        return tuKuDao.select();
    }

    @PostMapping("/upload")
    public int upLoadImg(@RequestBody TuKu tuKu) {
        String base64String = tuKu.getBase64();
        String[] dataArray = StrUtil.splitToArray(base64String, "base64,");
        byte[] bytes = Base64Decoder.decode(dataArray[1]);
        String name = IdUtil.simpleUUID() + "_" + tuKu.getName();
        FileUtil.writeBytes(bytes, baseUploadPath + name);
        tuKu.setName(name);
        tuKu.setImg("http://127.0.0.1:8084/images/"+name);
//        tuKu.setImg(baseUploadPath + "/" + name);
//        tuKu.setImg(baseUploadPath +"/images/"+ name);
        tuKuDao.insert(tuKu);
        return 1;
    }
}
