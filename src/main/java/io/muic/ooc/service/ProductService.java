package io.muic.ooc.service;

import io.muic.ooc.model.Product;
import io.muic.ooc.model.User;

import java.util.List;


/**
 * Created by joakimnilfjord on 3/11/2017 AD.
 */
public interface ProductService {
    //public Product findProductByProductName(String productname);
    public List<Product> findProductsByUser(User user);
    public void saveProduct(Product product,User user);
    public List<Product> findAllProducts();
    public Product findProductById(Long id);
    public void updateProductQuantity(Product product);



}
