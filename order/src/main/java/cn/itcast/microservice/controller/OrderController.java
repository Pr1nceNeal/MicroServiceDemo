package cn.itcast.microservice.controller;

import cn.itcast.microservice.pojo.Order;
import cn.itcast.microservice.service.ItemService;
import cn.itcast.microservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/order/{orderId}")
    public Order queryOrderById(@PathVariable(name = "orderId") String orderId) {
        return orderService.queryOrderById(orderId);
    }
}
