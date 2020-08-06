package com.leo.productdemo.dao.Impl;

import com.leo.productdemo.dao.ProductDao;
import com.leo.productdemo.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static Map<Integer, Product> productMap = null;
    private static Integer initId = 2005;

    static {
        productMap = new HashMap<Integer, Product>();
        productMap.put(2001, new Product(2001, "Car", 20000.0));
        productMap.put(2002, new Product(2002, "Book", 25.0));
        productMap.put(2003, new Product(2003, "Computer", 4999.0));
        productMap.put(2004, new Product(2004, "Computer", 6999.0));
    }

    public Collection<Product> getAll(){
        return productMap.values();
    }

    public Product get(Integer pid){
        return productMap.get(pid);
    }

    public Collection<Product> getAll(String productName){
        Collection<Product> products = getAll();

        if(!StringUtils.isEmpty( productName)){
            int count = 0;
            for(Product product: products){
                if(product.getProductName().toUpperCase().contains(productName.toUpperCase())){
                    count++;
                    products = count > 1? products: new ArrayList<>();
                    products.add(product);
                }
            }
        }
        return products;
    }

    public void add(Product product){
        if(product == null){
            return;
        }
        product.setPid(initId++);
        productMap.put(product.getPid(), product);
    }

    public void save(Product product){
        if(product.getPid() == null){
            product.setPid(initId++);
        }
        productMap.put(product.getPid(), product);
    }

    public void delete(Integer id){ productMap.remove(id); }

}
