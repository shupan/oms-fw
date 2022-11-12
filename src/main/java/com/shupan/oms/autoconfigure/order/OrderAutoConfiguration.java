package com.shupan.oms.autoconfigure.order;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.shupan.oms.fw.infra.properties.OrderProperties;
import org.skyer.core.jackson.annotation.EnableObjectMapper;
import org.skyer.core.util.CommonExecutor;
import org.skyer.resource.annoation.EnableSkyerResourceServer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author bojiangzhou 2018/10/25
 */
@ComponentScan(value = {"org.hippius.wd", "com.shupan.oms.fw.api", "com.shupan.oms.fw.app",
        "com.shupan.oms.fw.config", "com.shupan.oms.fw.domain", "com.shupan.oms.fw.infra"})
@EnableFeignClients({"com.shupan.oms.fw", "org.skyer", "org.skyer.plugin"})
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@EnableSkyerResourceServer
@EnableObjectMapper
@EnableAsync
@EnableConfigurationProperties({OrderProperties.class, DataHierarchyProperties.class})
public class OrderAutoConfiguration {

    /**
     * 通用线程池
     */
    @Bean
    @Qualifier("commonAsyncTaskExecutor")
    public ThreadPoolExecutor commonAsyncTaskExecutor() {
        int coreSize = CommonExecutor.getCpuProcessors();
        int maxSize = coreSize * 8;
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(coreSize, maxSize, 30, TimeUnit.MINUTES, new LinkedBlockingQueue<>(16),
                        new ThreadFactoryBuilder().setNameFormat("CommonExecutor-%d").build(),
                        new ThreadPoolExecutor.CallerRunsPolicy());

        CommonExecutor.displayThreadPoolStatus(executor, "SordCommonExecutor");
        CommonExecutor.hookShutdownThreadPool(executor, "SordCommonExecutor");

        return executor;
    }

}
