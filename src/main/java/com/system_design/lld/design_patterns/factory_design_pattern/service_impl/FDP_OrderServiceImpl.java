package com.system_design.lld.design_patterns.factory_design_pattern.service_impl;

import com.system_design.lld.design_patterns.factory_design_pattern.dao.FDP_OrderRepository;
import com.system_design.lld.design_patterns.factory_design_pattern.dto.OrderResponseDTO;
import com.system_design.lld.design_patterns.factory_design_pattern.dto.OrderRequestDTO;
import com.system_design.lld.design_patterns.factory_design_pattern.entity.OrderEntity;
import com.system_design.lld.design_patterns.factory_design_pattern.service.OrderService;
import com.system_design.lld.design_patterns.factory_design_pattern.service.PaymentService;
import com.system_design.lld.design_patterns.factory_design_pattern.util.PaymentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FDP_OrderServiceImpl implements OrderService {
    @Autowired
    private PaymentFactory paymentFactory;

    @Autowired
    private FDP_OrderRepository orderRepository;

    @Override
    public OrderResponseDTO processOrder(OrderRequestDTO requestDTO) {
        try {
            // Fetch correct Payment Service
            PaymentService paymentService = paymentFactory.getPaymentService(requestDTO.getPaymentMethod());

            boolean paymentSuccess = paymentService.processPayment(requestDTO.getAmount());

            // Convert DTO to Entity
            OrderEntity order = new OrderEntity(requestDTO);
            order.setProcessed(paymentSuccess);

            // Save to MongoDB
            OrderEntity savedOrder = orderRepository.save(order);

            // Convert Entity to Response DTO
            return new OrderResponseDTO(
                    savedOrder.getId(),
                    savedOrder.getUserId(),
                    savedOrder.getAmount(),
                    savedOrder.getPaymentMethod(),
                    savedOrder.isProcessed(),
                    paymentSuccess ? "Order processed successfully!" : "Payment failed!"
            );

        } catch (Exception e) {
            // Handle errors gracefully
            return new OrderResponseDTO(
                    null, requestDTO.getUserId(), requestDTO.getAmount(),
                    requestDTO.getPaymentMethod(), false,
                    "Invalid payment method: " + requestDTO.getPaymentMethod()
            );
        }
    }
}
