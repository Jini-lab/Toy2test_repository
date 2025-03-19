package com.fineapple.domain.order_payment.repository;

import com.fineapple.domain.order_payment.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrdersMapper {

    // 기존의 주문 조회 메서드
    Orders selectOrderById(@Param("orderId") Long orderId);

    // 🔹 추가된 주문 목록 조회 메서드
//    void insertOrder(Orders orders);
//    Orders insertOrder();
}
