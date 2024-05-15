package com.asgard.consumer.mrs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.asgard.consumer.mrs.model.Order;
import com.asgard.consumer.mrs.repository.OrderRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {


    public final OrderRepo orderRepo;

        public List<Order> findorders(Integer integer) {
        return orderRepo.findByid(integer);
    }

}
