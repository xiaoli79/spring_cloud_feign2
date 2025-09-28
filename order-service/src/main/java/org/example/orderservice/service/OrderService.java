package org.example.orderservice.service;

import api.ProductApi;
import model.ProductInfo;

import org.example.orderservice.mapper.OrderMapper;
import org.example.orderservice.model.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class OrderService {
//  通过restTemplate来进行对象的关联
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderMapper orderMapper;



    @Autowired
    private ProductApi productApi;

    public OrderInfo selectOrderById(Integer orderId){
        OrderInfo orderInfo = orderMapper.selectOrderById(orderId);

//        String url = "http://product-service/product/"+orderInfo.getProductId();
//        ProductInfo template = restTemplate.getForObject(url, ProductInfo.class);
//        orderInfo.setProductInfo(template);

//      使用openFeign实现远程调用~~
        ProductInfo productInfo = productApi.getProductInfo(orderInfo.getProductId());
        orderInfo.setProductInfo(productInfo);
        return orderInfo;
    }
}
