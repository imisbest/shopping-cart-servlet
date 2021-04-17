package com.csw.service;

import com.csw.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryPersonByArray(int currPage, int pageSize, Integer countPage);

    Integer countPageAction();

    Product getProductById(Integer id);

    Integer countPageLike(String productName, Double price, Integer opt);

    List<Product> queryPersonByArrayLike(int currPage, int pageSize, String productName,
                                         Double price, Integer opt, Integer countPage);
}
