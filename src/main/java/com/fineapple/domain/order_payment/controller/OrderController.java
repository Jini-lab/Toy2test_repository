package com.fineapple.domain.order_payment.controller;

import com.fineapple.domain.order_payment.entity.Orders;
import com.fineapple.domain.order_payment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    // 생성자 주입을 수동으로 구현
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    /*
    * 특정 주문 번호로 주문 조회 페이지
     * @param orderId 주문 ID
     * @return 주문 상세 페이지 (order-detail.html)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable Long id) {
        Orders order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
}