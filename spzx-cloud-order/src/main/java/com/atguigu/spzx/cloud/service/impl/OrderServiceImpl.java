package com.atguigu.spzx.cloud.service.impl;

import com.atguigu.spzx.cloud.entity.Order;
import com.atguigu.spzx.cloud.entity.User;
import com.atguigu.spzx.cloud.mapper.OrderMapper;
import com.atguigu.spzx.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

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
        //根据服务名 通过DiscoveryClient对象动态获取一个服务的实例(微服务的调用地址)
        ServiceInstance serviceInstance = this.getserviceInstance("spzx-cloud-user");
        //获取服务的ip地址
        String host = serviceInstance.getHost();
        //获取服务的端口号
        int port = serviceInstance.getPort();

        //>>>远程调用 用户服务 获取用户信息
        //发送Get请求  参数1:请求的地址   参数2:接收返回值的类
        User user = restTemplate.getForObject("http://"+host+":"+port+"/user/findById/"+userId, User.class);

        //封装到order对象中后返回
        order.setUser(user);
        return order;
    }
    //根据服务名获取服务实列
    public ServiceInstance getserviceInstance(String name){
        //获取服务列表
        List<ServiceInstance> list = discoveryClient.getInstances(name)         ;

        //随机生成一个下标
        int random = new Random().nextInt(list.size());
        //随机返回一个服务实例 负载均衡的算法
        return list.get(random);

    }
}
