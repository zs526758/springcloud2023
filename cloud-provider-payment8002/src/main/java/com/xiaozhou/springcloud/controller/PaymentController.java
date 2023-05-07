package com.xiaozhou.springcloud.controller;


import com.xiaozhou.springcloud.entities.CommonResult;
import com.xiaozhou.springcloud.entities.Payment;
import com.xiaozhou.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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


}
