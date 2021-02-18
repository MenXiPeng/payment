package com.mxp.payment.controller;

import com.mxp.cloudapicommon.entity.CommonResult;
import com.mxp.cloudapicommon.entity.Payment;
import com.mxp.payment.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Log4j2
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private Integer port;


    @RequestMapping("/getPort")
    public CommonResult<Map<String,Object>> payment() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(10000);
        commonResult.setMessage("success");
        commonResult.setData(Map.of("port", port));
        return commonResult;
    }

    @RequestMapping("/get-discovery")
    public DiscoveryClient getDiscovery(){

        List<String> services = discoveryClient.getServices();

        for (String s: services) {
            System.out.println("*****:" + s);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("PAYMENT");

        for (ServiceInstance s : instances) {
            System.out.println("uri----:"+s.getUri());
        }

        return this.discoveryClient;

    }


    @PostMapping("/info")
    public CommonResult<List<Payment>> info(@RequestBody Payment payment){
        var commonResult = new CommonResult<List<Payment>>();
        var paymentList = paymentService.find(payment);
        commonResult.setCode(10000);
        commonResult.setData(paymentList);
        commonResult.setMessage("success");
        return commonResult;
    }


}
