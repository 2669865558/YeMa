package com.dachun.entity;

import lombok.Data;

/**
 * @className VenueQuery
 * @description TODO
 * @date 2022/12/1 9:27
 */
@Data
public class VenueQuery extends AbsQuery{

    private  Integer id;
    private  String name;
    private  String country;

}

