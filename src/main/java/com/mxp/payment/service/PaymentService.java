package com.mxp.payment.service;

import com.mxp.cloudapicommon.entity.Payment;

import java.util.List;

public interface PaymentService {

    List<Payment> findAll();

}
