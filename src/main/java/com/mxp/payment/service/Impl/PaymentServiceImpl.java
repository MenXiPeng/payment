package com.mxp.payment.service.Impl;

import com.mxp.cloudapicommon.entity.Payment;
import com.mxp.payment.mapper.PaymentMapper;
import com.mxp.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public List<Payment> findAll() {
        return this.paymentMapper.selectAll();
    }

    @Override
    public List<Payment> find(Payment payment) {
        return paymentMapper.find(payment);
    }
}
