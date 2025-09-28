package org.example.orderservice.controller;


import api.ProductApi;
import model.ProductInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/feign")
@RestController
public class FeignController {


    @Autowired
    ProductApi productApi;

    @RequestMapping("/o1")

    public String o1(Integer id){
        return productApi.p1(id);
    }

    @RequestMapping("/o2")
    public String o2(Integer id, String name){
        return productApi.p2(id,name);
    }

    @RequestMapping("/o3")
    public String o3(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(45);
        productInfo.setProductName("T恤");
        return productApi.p3(productInfo);
    }

    @RequestMapping("/o4")
    public String o4(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setId(46);
        productInfo.setProductName("T恤46");
        return productApi.p4(productInfo);
    }
}
