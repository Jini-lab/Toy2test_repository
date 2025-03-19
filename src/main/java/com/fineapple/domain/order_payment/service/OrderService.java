package com.fineapple.domain.order_payment.service;

import com.fineapple.domain.order_payment.entity.Orders;
import com.fineapple.domain.order_payment.repository.OrdersMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {
    private final OrdersMapper ordersMapper;

    // 생성자 주입
    @Autowired
    public OrderService(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    // 주문 ID를 통해 주문을 조회하는 메서드
    public Orders getOrderById(Long id) {
        return ordersMapper.selectOrderById(id);
    }


}