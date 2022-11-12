package com.shupan.oms.fw.api.controller.v1;

import com.shupan.oms.fw.app.service.OrderService;
import com.shupan.oms.fw.domain.entity.OrderLogistics;
import com.shupan.oms.fw.domain.repository.OrderLogisticsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService mockOrderService;
    @MockBean
    private OrderLogisticsRepository mockOrderLogisticsRepository;

    @Test
    void testGetOrderList() {
        // Setup
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
        when(mockOrderLogisticsRepository.selectByIds("orderId")).thenReturn(orderLogistics);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/v1/order/order-page")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("expectedResponse", response.getContentAsString());
    }

    @Test
    void testGetOrderList_OrderLogisticsRepositoryReturnsNoItems() {
        // Setup
        when(mockOrderLogisticsRepository.selectByIds("orderId")).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/v1/order/order-page")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("[]", response.getContentAsString());
    }

    @Test
    void testGetOrderList_ThrowsException() {
        // Setup
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
        when(mockOrderLogisticsRepository.selectByIds("orderId")).thenReturn(orderLogistics);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/v1/order/order-page")
                        .content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatus());
        assertEquals("expectedResponse", response.getContentAsString());
    }
}
