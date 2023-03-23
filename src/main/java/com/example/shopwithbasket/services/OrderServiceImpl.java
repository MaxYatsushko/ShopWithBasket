package com.example.shopwithbasket.services;

import com.example.shopwithbasket.entities.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(WebApplicationContext.SCOPE_SESSION)
public class OrderServiceImpl implements OrderService {

    private List<Order> orders = new ArrayList<>();


    public List<Order> add(List<Integer> ids){

        List<Order> newOrders = ids.stream()
                .map(id -> new Order(id))
                .collect(Collectors.toList());

        orders.addAll(newOrders);
        return newOrders;
    }

    public List<Order> getAll(){
        return orders;
    }
}
