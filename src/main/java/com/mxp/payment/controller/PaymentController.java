package com.mxp.payment.controller;

import com.mxp.cloudapicommon.entity.CommonResult;
import com.mxp.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public CommonResult<Map<String,Object>> payment(){
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


}
