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
    }
}
