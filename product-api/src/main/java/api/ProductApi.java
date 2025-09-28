package api;

import model.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="product-service",path="product")
public interface ProductApi {

    @RequestMapping("{productId}")
    ProductInfo getProductInfo(@PathVariable("productId") Integer productId);


    @RequestMapping("p1")
    String p1(@RequestParam("id") Integer id);


    @RequestMapping("/p2")
    String p2(@RequestParam("id") Integer id, @RequestParam("name") String name);

    @RequestMapping("/p3")
    String p3(@SpringQueryMap ProductInfo productInfo);

    @RequestMapping("/p4")
    String p4(@RequestBody ProductInfo productInfo);

}