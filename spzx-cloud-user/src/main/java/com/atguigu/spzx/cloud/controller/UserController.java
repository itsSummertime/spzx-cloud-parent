package com.atguigu.spzx.cloud.controller;


import com.atguigu.spzx.cloud.entity.User;
import com.atguigu.spzx.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-10-20
 */
@RestController
@RequestMapping("/user")
public class   UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findById/{id}")
    public User findbyId(@PathVariable long id){
        return userService.findById(id);
    }
}

