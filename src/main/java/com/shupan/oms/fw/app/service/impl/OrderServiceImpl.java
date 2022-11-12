package com.shupan.oms.fw.app.service.impl;

import com.shupan.oms.fw.api.dto.OrderBaseInfoDTO;
import com.shupan.oms.fw.app.service.OrderService;
import com.shupan.oms.fw.domain.entity.OrderLogistics;
import com.shupan.oms.fw.domain.repository.OrderLogisticsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @description
 * @Author wusc
 * @create 2022/1/20 2:31 下午
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderLogisticsRepository orderLogisticsRepository;



    @Override
    public void createInnerOrderBpmn(OrderBaseInfoDTO orderBaseInfoDTO) {
        OrderLogistics orderLogistics = new OrderLogistics();
//        BeanUtils.copyProperties(orderLogistics, orderBaseInfoDTO);
//        orderLogisticsRepository.insert(orderLogistics);
        orderLogisticsRepository.selectByIds("aaa");
        System.out.println("it is ok ");
    }

}
