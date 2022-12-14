package com.shupan.oms.fw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Skyer平台服务启动类 主要包含平台通用功能
 *
 * @author
 */
@SpringBootApplication
//@EnableZeebeClient
//@EnableSkyerOrder
//@EnableDiscoveryClient
public class OrderApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(OrderApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
