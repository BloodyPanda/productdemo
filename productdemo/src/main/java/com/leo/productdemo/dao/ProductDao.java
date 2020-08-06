package com.leo.productdemo.dao;

import com.leo.productdemo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public interface ProductDao {
    Collection<Product> getAll();
    Product get(Integer pid);
    Collection<Product> getAll(String productName);
    void save(Product product);
    void delete(Integer id);
    void add(Product product);
}
