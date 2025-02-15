package com.system_design.lld.design_patterns.decorator_design_pattern.service_impl;

import com.system_design.lld.design_patterns.decorator_design_pattern.dao.OrderRepository;
import com.system_design.lld.design_patterns.decorator_design_pattern.dao.UserRepository;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderRequestDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.dto.OrderResponseDTO;
import com.system_design.lld.design_patterns.decorator_design_pattern.entity.OrderEntity;
import com.system_design.lld.design_patterns.decorator_design_pattern.entity.UserEntity;
import com.system_design.lld.design_patterns.decorator_design_pattern.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<OrderResponseDTO> processOrder(OrderRequestDTO order) {
        Optional<UserEntity> userOptional = userRepository.findById(order.getUserId());
        OrderResponseDTO response = new OrderResponseDTO();
        if (userOptional.isEmpty()) {
            response.setMessage("User not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        UserEntity user = userOptional.get();
        OrderEntity newOrder = new OrderEntity(UUID.randomUUID().toString(), order.getDetails(),  order.getPrice(), order.getDecorators(),"Processed", user);
        newOrder = orderRepository.save(newOrder);
        if (user.getOrderIds() == null) {
            user.setOrderIds(new ArrayList<>());
        }
        user.getOrderIds().add(newOrder.getId());
        userRepository.save(user);
        response = new OrderResponseDTO(newOrder.getId(), newOrder.getDetails(), newOrder.getAppliedDecorators(), newOrder.getPrice(), "Order processed successfully", user);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
