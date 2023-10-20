package com.atguigu.spzx.cloud.controller;


import com.atguigu.spzx.cloud.entity.Order;
import com.atguigu.spzx.cloud.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("findById/{id}")
    public Order findById(@PathVariable long id){
        return orderService.findById(id);

    }
}

