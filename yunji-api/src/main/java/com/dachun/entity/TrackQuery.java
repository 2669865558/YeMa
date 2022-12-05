package com.dachun.entity;

import lombok.Data;

/**
 * @className TrackQuery
 * @description TODO
 * @date 2022/12/6 9:55
 */
@Data
public class TrackQuery {

    private String startDate;
    private String endDate;
    private Integer[] venueIds;
}

