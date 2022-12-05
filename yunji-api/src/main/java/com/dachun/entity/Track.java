package com.dachun.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @className Track
 * @description TODO
 * @date 2022/12/6 9:53
 */
@Data
public class Track {
    private String id;
    private  String personId;
    private LocalDateTime time;
    private Integer venueId;
}
