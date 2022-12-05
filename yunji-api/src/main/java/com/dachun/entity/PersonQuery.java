package com.dachun.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @className PersonQuery
 * @description TODO
 * @date 2022/12/4 21:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PersonQuery extends  AbsQuery {

    private String id;
    private String  name;
    private String phone;
    private Integer venueId;


}

