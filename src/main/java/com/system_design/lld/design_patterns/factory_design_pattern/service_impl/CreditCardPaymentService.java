package com.system_design.lld.design_patterns.factory_design_pattern.service_impl;

import com.system_design.lld.design_patterns.factory_design_pattern.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("CREDIT_CARD")
public class CreditCardPaymentService implements PaymentService {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + amount);
        return true; // Assume payment is always successful
    }
}
