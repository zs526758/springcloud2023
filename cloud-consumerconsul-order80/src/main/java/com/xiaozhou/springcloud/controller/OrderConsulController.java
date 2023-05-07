package com.xiaozhou.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 *   TODO
 * </P>
 *
 * @date: 2023/5/8
 * @author: xz
 * @version: 1.0
 */
@RestController
public class OrderConsulController {
    public static final String INVOKE_URL = "http://consul-provider-payment"; //consul-provider-payment

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/consul", String.class);
        System.out.println("消费者调用支付服务(consule)--->result:" + result);
        return result;
    }
}
