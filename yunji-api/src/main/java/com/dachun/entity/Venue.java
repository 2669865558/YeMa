package com.dachun.entity;

import lombok.Data;

/**
 * @className Venue
 * @description TODO
 * @date 2022/12/1 9:27
 */
@Data
public class Venue {
    private  Integer id;
    private  String name;
    private  String img;
    private  String province;
    private  String city;
    private  String country;
    private  String address;
    private  String lng;
    private  String lat;
    private  String brief;
    private  String seq;
}
