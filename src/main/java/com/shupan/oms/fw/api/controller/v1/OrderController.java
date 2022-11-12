package com.shupan.oms.fw.api.controller.v1;

import com.shupan.oms.fw.api.dto.OrderPageDTO;
import com.shupan.oms.fw.app.service.OrderService;
import com.shupan.oms.fw.domain.entity.OrderLogistics;
import com.shupan.oms.fw.domain.repository.OrderLogisticsRepository;
import io.swagger.annotations.ApiOperation;
import org.skyer.core.base.BaseController;
import org.skyer.core.iam.ResourceLevel;
import org.skyer.core.util.Results;
import org.skyer.swagger.annotation.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @description
 * @Author wusc
 * @create 2022/1/18 2:37 下午
 */
@RestController("orderController.v1")
@RequestMapping("/v1/order")
public class OrderController extends BaseController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderLogisticsRepository orderLogisticsRepository;

    @ApiOperation(value = "订单列表")
    @Permission(level = ResourceLevel.SITE  ,permissionLogin = true)
    @PostMapping("/order-page")
    public ResponseEntity<List<OrderLogistics>> getOrderList(@RequestBody OrderPageDTO orderPageDTO) throws Exception {
        List<OrderLogistics> list = orderLogisticsRepository.selectByIds(orderPageDTO.getOrderId());
        return Results.success(list);
    }

//    @ApiOperation(value = "订单列表")
//    @Permission(level = ResourceLevel.SITE  ,permissionLogin = true)
//    @PostMapping("/order-page")
//    public ResponseEntity<Page<OrderPageVo>> orderPage(@RequestBody SearchOrderEsParam searchOrderEsParam) throws Exception {
//        Page<OrderPageVo> list = orderEsService.queryOrderPageEs(searchOrderEsParam);
//        return Results.success(list);
//    }
}
