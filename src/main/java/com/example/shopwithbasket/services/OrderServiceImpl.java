package com.example.shopwithbasket.services;

import com.example.shopwithbasket.entities.Basket;
import com.example.shopwithbasket.entities.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final Basket basket;

    public OrderServiceImpl(Basket basket) {
        this.basket = basket;
    }

    public List<Order> getAll() {
        return basket.getAll();
    }

    public List<Order> add(List<Integer> ids){

        List<Order> newOrders = new ArrayList<>();

        for (Integer id : ids) {
            if (isId(id))
                continue;

            Order newOrder = new Order(id);
            newOrders.add(newOrder);
        }

        basket.add(newOrders);
        return newOrders;
    }

    private boolean isId(Integer id){
        for (Order order: basket.getAll()) {
            if(id.equals(order.getId()))
                return true;
        }
        return false;
    }

   /* private List<Order> orders = new ArrayList<>();

    public List<Order> add(List<Integer> ids){

        //пример без фильтрации уникальных для себя
        //List<Order> newOrders = ids.stream()
        //        .map(id -> new Order(id))
        //        .collect(Collectors.toList());

        List<Order> newOrders = new ArrayList<>();

        for (Integer id : ids) {
           if (isId(id))
               continue;

           Order newOrder = new Order(id);
           newOrders.add(newOrder);
        }

        orders.addAll(newOrders);
        return newOrders;
    }

    public List<Order> getAll(){
        return orders;
    }

    private boolean isId(Integer id){
        for (Order order: orders) {
            if(id.equals(order.getId()))
                return true;
        }
        return false;
    }*/
}
