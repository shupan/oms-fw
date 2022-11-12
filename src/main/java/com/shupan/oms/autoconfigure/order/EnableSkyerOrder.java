package com.shupan.oms.autoconfigure.order;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author bojiangzhou 2018/10/25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@DocumentedS
@Import(OrderAutoConfiguration.class)
public @interface EnableSkyerOrder {

}
