package com.atguigu.spzx.cloud.service.impl;

import com.atguigu.spzx.cloud.entity.Order;
import com.atguigu.spzx.cloud.entity.User;
import com.atguigu.spzx.cloud.mapper.OrderMapper;
import com.atguigu.spzx.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    /**
     * Spring框架提供的一个客户端，用于发送HTTP请求
     * RestTemplate对象需要手动创建，再存入Spring容器，此处才能使用@Autowired注入
     */
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;


    @Override
    public Order findById(long id) {
        //根据订单id查询到 订单信息
        Order order = orderMapper.findById(id);
        //获取到用户id
        Long userId = order.getUserId();

        //>>>远程调用 用户服务 获取用户信息
        //如果使用服务名调用，则必须加上@LoadBalanced，默认使用轮询的负载均衡算法
        User user = restTemplate.getForObject("http://spzx-cloud-user/user/findById/"+userId, User.class);

        //封装到order对象中后返回
        order.setUser(user);
        return order;
    }
}
