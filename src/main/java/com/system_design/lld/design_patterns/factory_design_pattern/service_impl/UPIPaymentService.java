package com.system_design.lld.design_patterns.factory_design_pattern.service_impl;

import com.system_design.lld.design_patterns.factory_design_pattern.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("UPI")
public class UPIPaymentService implements PaymentService {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount);
        return true; // Assume payment is always successful
    }
}

