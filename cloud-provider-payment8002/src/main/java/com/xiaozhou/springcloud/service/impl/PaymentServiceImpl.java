package com.xiaozhou.springcloud.service.impl;

import com.xiaozhou.springcloud.dao.PaymentDao;
import com.xiaozhou.springcloud.entities.Payment;
import com.xiaozhou.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

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
@Service
public class PaymentServiceImpl implements PaymentService {
//import com.xiaozhou.springcloud.entities.Payment;
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
