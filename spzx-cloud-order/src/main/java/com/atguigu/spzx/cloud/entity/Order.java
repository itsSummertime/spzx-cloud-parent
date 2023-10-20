package com.atguigu.spzx.cloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author atguigu
 * @since 2023-10-20
 */
@Data
public class Order implements Serializable {
    private Long id;
    private Long userId;
    private String name;
    private Long price;
    private Integer num;


}
