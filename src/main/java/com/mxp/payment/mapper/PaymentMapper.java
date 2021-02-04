package com.mxp.payment.mapper;

import com.mxp.cloudapicommon.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PaymentMapper {
    List<Payment> selectAll();
}
