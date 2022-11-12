package com.shupan.oms.fw.app.service.impl;

import com.shupan.oms.fw.api.dto.OrderBaseInfoDTO;
import com.shupan.oms.fw.domain.entity.OrderLogistics;
import com.shupan.oms.fw.domain.repository.OrderLogisticsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class OrderServiceImplTest {

    @Mock
    private OrderLogisticsRepository mockOrderLogisticsRepository;

    @InjectMocks
    private OrderServiceImpl orderServiceImplUnderTest;

    private AutoCloseable mockitoCloseable;

    @BeforeEach
    void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockitoCloseable.close();
    }

    @Test
    void testCreateInnerOrderBpmn() {
        // Setup
        final OrderBaseInfoDTO orderBaseInfoDTO = new OrderBaseInfoDTO();
        orderBaseInfoDTO.setChannel("channel");
        orderBaseInfoDTO.setStoreId(0L);
        orderBaseInfoDTO.setStoreCode("storeCode");
        orderBaseInfoDTO.setStoreName("storeName");
        orderBaseInfoDTO.setOuterOrderNo("outerOrderNo");
        orderBaseInfoDTO.setBusinessType("businessType");
        orderBaseInfoDTO.setOrderTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        orderBaseInfoDTO.setPayStatus(0);
        orderBaseInfoDTO.setOrderRemarks("orderRemarks");
        orderBaseInfoDTO.setActionType("actionType");
        orderBaseInfoDTO.setCopyOrigin("copyOrigin");
        orderBaseInfoDTO.setTakingDeliveryStoreId(0L);
        orderBaseInfoDTO.setTakingDeliveryStoreName("takingDeliveryStoreName");
        orderBaseInfoDTO.setSalesEmployeeRealName("salesEmployeeRealName");
        orderBaseInfoDTO.setTakingDeliveryWay("takingDeliveryWay");

        // Configure OrderLogisticsRepository.selectByIds(...).
        final OrderLogistics orderLogistics1 = new OrderLogistics();
        orderLogistics1.setId(0L);
        orderLogistics1.setOuterOrderNo("outerOrderNo");
        orderLogistics1.setInnerOrderNo("innerOrderNo");
        orderLogistics1.setLogisticsNo("logisticsNo");
        orderLogistics1.setOutStockNo("outStockNo");
        orderLogistics1.setLogisticsCompany("logisticsCompany");
        orderLogistics1.setLogisticsBusinessName("logisticsBusinessName");
        orderLogistics1.setLogisticsStatus("logisticsStatus");
        orderLogistics1.setType(0L);
        orderLogistics1.setReceiveUser("receiveUser");
        orderLogistics1.setReceivePhone("receivePhone");
        orderLogistics1.setReceiveAddress("receiveAddress");
        orderLogistics1.setSendStockId(0L);
        orderLogistics1.setSendStockName("sendStockName");
        orderLogistics1.setSendUser("sendUser");
        final List<OrderLogistics> orderLogistics = Arrays.asList(orderLogistics1);
        when(mockOrderLogisticsRepository.selectByIds("aaa")).thenReturn(orderLogistics);

        // Run the test
        orderServiceImplUnderTest.createInnerOrderBpmn(orderBaseInfoDTO);

        // Verify the results
        verify(mockOrderLogisticsRepository).selectByIds("aaa");
    }
}
