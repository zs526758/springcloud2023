package com.xiaozhou.springcloud.controller;


import com.xiaozhou.springcloud.entities.CommonResult;
import com.xiaozhou.springcloud.entities.Payment;
import com.xiaozhou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *   TODO
 * </P>
 *
 * @date: 2023/5/6
 * @author: xz
 * @version: 1.0
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){
        log.info("payment:{}",payment);
        int result = paymentService.create(payment);
        log.info("result:{}",result);
        return  new CommonResult(200,"成功"+serverPort,result);

    }
    @GetMapping(value = "/get/{id}")
    public CommonResult getPaymentById(@PathVariable Long id){
        log.info("id:{}",id);
        Payment payment = paymentService.getPaymentById(id);
        log.info("result:{}",payment);
        return  new CommonResult(200,"成功"+serverPort,payment);
    }

    @GetMapping(value = "/discovery")
    public Object discovery()
    {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }


}
