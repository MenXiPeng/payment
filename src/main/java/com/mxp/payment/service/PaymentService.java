package com.mxp.payment.service;

import com.mxp.payment.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

}
