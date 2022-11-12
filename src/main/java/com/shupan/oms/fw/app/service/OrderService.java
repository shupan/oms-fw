package com.shupan.oms.fw.app.service;


import com.shupan.oms.fw.api.dto.OrderBaseInfoDTO;

/**
 * @description
 * @Author wusc
 * @create 2022/1/20 2:30 下午
 */
public interface OrderService {


    void createInnerOrderBpmn(OrderBaseInfoDTO orderBaseInfoDTO);
}
