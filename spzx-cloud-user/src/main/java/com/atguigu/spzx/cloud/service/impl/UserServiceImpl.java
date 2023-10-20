package com.atguigu.spzx.cloud.service.impl;

import com.atguigu.spzx.cloud.entity.User;
import com.atguigu.spzx.cloud.mapper.UserMapper;
import com.atguigu.spzx.cloud.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findById(long id) {
        return userMapper.findById(id);
    }
}
