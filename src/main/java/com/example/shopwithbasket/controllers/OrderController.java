package com.example.shopwithbasket.controllers;

import com.example.shopwithbasket.entities.Order;
import com.example.shopwithbasket.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/add")
    public List<Order> add(@RequestParam("ids") List<Integer> ids){
        return orderService.add(ids);
    }

    @GetMapping("/get")
    public List<Order> get(){
        return orderService.getAll();
    }
}
