package com.fineapple.domain.order_payment.repository;

import com.fineapple.domain.order_payment.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrdersMapper {

    // XML에 정의된 SQL을 호출
    Orders selectOrderById(@Param("orderId") Long orderId);

    void insertOrder(Orders orders);
}
