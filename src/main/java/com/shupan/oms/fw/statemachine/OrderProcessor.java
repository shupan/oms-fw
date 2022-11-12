package com.shupan.oms.fw.statemachine;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * 状态机引擎的处理器注解标识
 *
 * @author chenzz
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Component
public @interface OrderProcessor {

}
