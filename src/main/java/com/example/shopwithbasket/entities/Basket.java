package com.example.shopwithbasket.entities;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@SessionScope
@Component
public class Basket {
    private List<Order> orders = new ArrayList<>();

    public List<Order> add(List<Order> ordersList) {
        orders.addAll(ordersList);
        return ordersList;
    }

    public List<Order> getAll() {
        return orders;
    }

}