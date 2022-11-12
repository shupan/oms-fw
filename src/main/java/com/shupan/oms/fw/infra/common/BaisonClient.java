package com.shupan.oms.fw.infra.common;

import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

//import com.shupan.oms.fw.infra.enums.BaiSonServiceTypeEnum;

@Slf4j
@Service
public class BaisonClient {
    @Value("${baison.url}")
    private String url;
    @Value("${baison.key}")
    private String key;
    @Value("${baison.secret}")
    private String secret;
    @Value("${baison.param}")
    private String param;
    @Value("${baison.request-time-format}")
    private String requestTimeFormat;
    @Value("${baison.version}")
    private String version;

    //返回调用成功关键字
    public static final String STATUS = "api-success";

    private static final String KEY = "key";

    private static final String REQUEST_TIME = "requestTime";

    private static final String SECRET = "secret";

    private static final String VERSION = "version";

    private static final String SERVICE_TYPE = "serviceType";

    private static final String DATA_NAME = "data";

    private static final String SIGN = "sign";

    //定义一个Http客户端超时请求和监听
    private final OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .connectTimeout(15, TimeUnit.SECONDS)//设置连接超时时间
            .readTimeout(15, TimeUnit.SECONDS)//设置读取超时时间
            .addInterceptor(new LogInterceptor())
            .build();
}
