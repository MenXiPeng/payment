package com.mxp.payment.controller;


import com.mxp.payment.entity.CommonResult;
import com.mxp.payment.entity.Payment;
import com.mxp.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    public CommonResult<Payment> payment(){

        return null;
    }


}
