package com.fineapple.domain.order_payment.service;

import com.fineapple.domain.order_payment.entity.Orders;
import com.fineapple.domain.order_payment.repository.OrdersMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @Mock
    private OrdersMapper ordersMapper; // OrdersMapper를 Mock 객체로 생성

    @InjectMocks
    private OrderService orderService; // 테스트할 OrderService를 주입

    private Orders mockOrder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this); // Mock 객체 초기화
        // Orders 객체를 빌더 패턴으로 생성하여 테스트에 사용할 Mock 데이터 준비
        mockOrder = Orders.builder()
                .orderId(1L)
                .orderCode(1001L)
                .guestId(2001L)
                .userId(3001L)
                .deliveryId(4001L)
                .totalPrice(new BigDecimal("150.00"))
                .discountPrice(new BigDecimal("10.00"))
                .isCancelled(false)
                .orderStatus("PROCESSING")
                .paymentMethod("CREDIT_CARD")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Test
    public void 주문생성() {
        // given: 특정 주문 ID에 대해 Mock 객체가 반환될 것이라고 설정
        Long orderId = 1L;
        when(ordersMapper.selectOrderById(orderId)).thenReturn(mockOrder);

        // when: 실제 서비스 메서드 호출
        Orders foundOrder = orderService.getOrderById(orderId);

        // then: 반환된 주문 정보가 예상한 값과 일치하는지 검증
        assertNotNull(foundOrder); // 반환된 주문이 null이 아닌지 확인
        assertEquals(orderId, foundOrder.getOrderId()); // 주문 ID가 일치하는지 확인
        assertEquals("CREDIT_CARD", foundOrder.getPaymentMethod()); // 결제 방법이 일치하는지 확인
        assertEquals(new BigDecimal("150.00"), foundOrder.getTotalPrice()); // 총 가격이 일치하는지 확인
        assertEquals("PROCESSING", foundOrder.getOrderStatus()); // 주문 상태가 일치하는지 확인
    }

    @Test
    public void 주문조회() {
        // given: 특정 주문 ID에 대해 Mock 객체가 반환될 것이라고 설정
        Long orderId = 1L;
        when(ordersMapper.selectOrderById(orderId)).thenReturn(mockOrder);

        // when: 실제 서비스 메서드 호출
        Orders foundOrder = orderService.getOrderById(orderId);

        // then: 반환된 주문 정보가 예상한 값과 일치하는지 검증
        assertNotNull(foundOrder); // 반환된 주문이 null이 아닌지 확인
        assertEquals(orderId, foundOrder.getOrderId()); // 주문 ID가 일치하는지 확인
    }

    @Test
    public void 주문취소() {

    }

    @Test
    public void 주문수정() {

    }

    @Test
    public void 주문상세수정() {

    }

    @Test
    public void 주문상태변경() {

    }
}
