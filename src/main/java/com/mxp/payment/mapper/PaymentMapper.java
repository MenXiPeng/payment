package com.mxp.payment.mapper;

import com.mxp.payment.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    List<Payment> selectAll();
}
