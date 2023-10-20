package com.atguigu.spzx.cloud.service;

import com.atguigu.spzx.cloud.entity.Order;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-10-20
 */
public interface OrderService {

    Order findById(long id);
}
