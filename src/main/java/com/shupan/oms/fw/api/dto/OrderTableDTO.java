package com.shupan.oms.fw.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 订单创建dto
 * @description
 * @Author wusc
 * @create 2022/1/18 1:18 下午
 */
@Data
public class OrderTableDTO {

    @ApiModelProperty("订单基础信息")
    private OrderBaseInfoDTO orderBaseInfoDTO;

}
