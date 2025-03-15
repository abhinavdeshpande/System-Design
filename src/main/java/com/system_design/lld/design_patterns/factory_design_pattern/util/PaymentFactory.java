package com.system_design.lld.design_patterns.factory_design_pattern.util;

import com.system_design.lld.design_patterns.factory_design_pattern.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class PaymentFactory {
    @Autowired
    private ApplicationContext context;

    public PaymentService getPaymentService(String paymentMethod) {
        return context.getBean(paymentMethod, PaymentService.class);
    }
}
