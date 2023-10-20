package com.atguigu.spzx.cloud.service.impl;

import com.atguigu.spzx.cloud.entity.Order;
import com.atguigu.spzx.cloud.mapper.OrderMapper;
import com.atguigu.spzx.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-10-20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Order findById(long id) {
        return orderMapper.findById(id);
    }
}
