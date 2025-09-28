package org.example.productservice.controller;


import lombok.NonNull;
import org.example.productservice.model.ProductInfo;
import org.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;


    @RequestMapping("/{productId}")
    public ProductInfo selectProductInfoById(@PathVariable("productId") @NonNull Integer productId) {
        return productService.selectProductInfoByProductId(productId);

    }


    @RequestMapping("p1")
    public String p1(Integer id){
        return "product-service 接收到的参数 id=" +id;
    }

    @RequestMapping("/p2")
    public String p2(Integer id, String name){
        return "product-service 接收到参数, id:"+id+",name:"+name;
    }
    @RequestMapping("/p3")
    public String p3(ProductInfo productInfo){
        return "product-service 接收到参数: productInfo"+productInfo.toString();
    }

    @RequestMapping("/p4")
    public String p4(@RequestBody ProductInfo productInfo){
        return "product-service 接收到参数: productInfo"+productInfo.toString();
    }
}
