package com.leo.productdemo.service;

import com.leo.productdemo.dao.ProductDao;
import com.leo.productdemo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    public Collection<Product> findAllProducts(){
        return productDao.getAll();
    }

    public Collection<Product> findProductsByName(String productName){
        return productDao.getAll(productName);
    }

    public Product findProductByPid(Integer pid){
        return productDao.get(pid);
    }

    public String addProduct(Product product){
        if(product == null) {
            return "add fail";
        }
        productDao.add(product);
        if(productDao.getAll(product.getProductName()).size() == 0) {
            return "add fail";
        }
        return "add success";
    }

    public String updateProduct(Product product) {
        if(product == null) {
            return "update fail";
        }
        productDao.save(product);
        if(productDao.get(product.getPid()) == null) {
            return "update fail";
        }
        return "update success";
    }

    public String deleteProduct(Integer pid) {
        productDao.delete(pid);
        if(productDao.get(pid) != null){
            return "delete fail";
        }
        return "delete success";
    }

}
