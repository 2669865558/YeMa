package com.dachun.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.StrUtil;
import com.dachun.model.UserFace;
import com.dachun.model.UserFaceCheck;
import com.dachun.service.MyFaceEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @className FaceController
 * @description TODO
 * @date 2022/12/5 10:06
 */
@RestController
@RequestMapping("/face-api/face")
public class FaceController {

    @Autowired
    private MyFaceEngine myFaceEngine;

    @Resource(name = "bytesHashOperations")
    private HashOperations<String, String, byte[]> hashOperations;


    //采集人脸
    @PostMapping("/up")
    public Integer upload(@RequestBody UserFace userFace) {

        String base64String = userFace.getFaceImg();

        String[] dataArray = StrUtil.splitToArray(base64String, "base64,");

        byte[] bytes = Base64.decode(dataArray[1]);

        byte[] feature = myFaceEngine.getFeature(bytes);

        String daKey = "venue." + userFace.getVenueId();
        String xiaoKey = userFace.getId().toString();
        hashOperations.put(daKey, xiaoKey, feature);

        return 1;
    }

    //校验人脸
    @PostMapping("/check")
    public String check(@RequestBody UserFaceCheck userFaceCheck) {
        String base64String = userFaceCheck.getFaceImg();
        String[] dataArray = StrUtil.splitToArray(base64String, "base64,");
        byte[] bytes = Base64.decode(dataArray[1]);
        byte[] feature = myFaceEngine.getFeature(bytes);

        String daKey = "venue." + userFaceCheck.getVenueId();

        Map<String, byte[]> entries = hashOperations.entries(daKey);

        for (Map.Entry<String, byte[]> entry : entries.entrySet()) {

            float score = myFaceEngine.compare(feature, entry.getValue());
            if (score > 0.90) {
                return "ok";
            }
        }
        return "nobody";
    }
}
