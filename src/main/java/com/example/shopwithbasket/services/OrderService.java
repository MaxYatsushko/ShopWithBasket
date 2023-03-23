package com.example.shopwithbasket.services;

import com.example.shopwithbasket.entities.Order;

import java.util.List;

public interface OrderService {

   List<Order> add(List<Integer> ids);
   List<Order> getAll();
}
