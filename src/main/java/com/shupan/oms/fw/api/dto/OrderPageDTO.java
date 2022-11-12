package com.shupan.oms.fw.api.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderPageDTO {

    @ApiModelProperty(value = "订单ID")
    private String orderId ;

}
