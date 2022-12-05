package com.dachun.entity;

import lombok.Data;

/**
 * @className Person
 * @description TODO
 * @date 2022/12/4 21:41
 */
@Data
public class Person {
    private String id;
    private String  name;
    private String phone;
    private String address;
    private Integer venueId;
    private Integer faceFlag;
}
