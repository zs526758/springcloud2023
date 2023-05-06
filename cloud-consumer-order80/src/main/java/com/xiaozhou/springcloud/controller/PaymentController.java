 package com.xiaozhou.springcloud.controller;

 import com.xiaozhou.springcloud.entities.CommonResult;
 import com.xiaozhou.springcloud.entities.Payment;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.web.bind.annotation.*;
 import org.springframework.web.client.RestTemplate;

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
@RequestMapping("/consumer/payment")
public class PaymentController {

    public static final String PaymentSrv_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult create(@RequestBody Payment payment)
    {
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPayment(@PathVariable Long id)
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/payment/get/"+id, CommonResult.class);
    }

}
