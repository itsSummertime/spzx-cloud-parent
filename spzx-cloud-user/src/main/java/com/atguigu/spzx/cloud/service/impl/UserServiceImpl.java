package com.atguigu.spzx.cloud.service.impl;

import com.atguigu.spzx.cloud.entity.User;
import com.atguigu.spzx.cloud.mapper.UserMapper;
import com.atguigu.spzx.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Value("${server.port}") ///读取项目中的server.port配置的值，注入String port
    private String port;
    @Override
    public User findById(long id) {
        User user = userMapper.findById(id);
        user.setUserName(user.getUserName()+ ",端口号:" +port);
        return user;
    }
}
