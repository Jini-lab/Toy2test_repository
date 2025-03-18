package com.fineapple.domain.order_payment.controller;

import com.fineapple.domain.order_payment.entity.Orders;
import com.fineapple.domain.order_payment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")

public class OrderController {

    private final OrderService orderService;

    // 생성자 주입을 수동으로 구현
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    /**
     * 주문 정보를 조회하는 API
     *
     * @param id 주문 ID
     * @return 주문 정보 (응답값으로 Orders 객체를 반환)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrder(@PathVariable Long id) {
        // OrderService를 통해 주문 정보 조회
        Orders order = orderService.getOrderById(id);

        // 조회된 주문 정보를 ResponseEntity로 감싸서 반환
        return ResponseEntity.ok(order);  // 정상적으로 조회된 경우 200 OK 응답과 함께 주문 정보 반환
    }
}
