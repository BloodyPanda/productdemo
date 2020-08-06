package com.leo.productdemo.controller;

import com.leo.productdemo.dao.ProductDao;
import com.leo.productdemo.model.Product;
import com.leo.productdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public Collection<Product> viewAll(@RequestParam(value="productName", required = false) String productName){
        if(productName == null){
            return productService.findAllProducts();
        } else {
            return productService.findProductsByName(productName);
        }
    }

    @GetMapping("/products/{pid}")
    public Product view(@PathVariable("pid") Integer pid){
        return productService.findProductByPid(pid);
    }

    @PostMapping("/products")
    public String add(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/products")
    public String update(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("products/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        return productService.deleteProduct(pid);
    }

}
