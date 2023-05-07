package com.xiaozhou.springcloud.service;

import com.xiaozhou.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *   TODO
 * </P>
 *
 * @date: 2023/5/6
 * @author: xz
 * @version: 1.0
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
