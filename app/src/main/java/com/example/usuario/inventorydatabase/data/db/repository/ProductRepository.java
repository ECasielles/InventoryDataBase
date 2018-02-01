package com.example.usuario.inventorydatabase.data.db.repository;

import com.example.usuario.inventorydatabase.data.db.dao.ProductDao;
import com.example.usuario.inventorydatabase.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 26/10/17.
 */

public class ProductRepository {

    private static ProductRepository productRepository;

    static {
        productRepository = new ProductRepository();
    }

    private ProductDao productDao;

    private ProductRepository() {
        productDao = new ProductDao();
    }


    public static ProductRepository getInstance() {
        if (productRepository == null)
            productRepository = new ProductRepository();
        return productRepository;
    }

    public ArrayList<Product> getProducts() {
        return productDao.loadAll();
    }

    public void addProduct(Product product) {
        long id = productDao.add(product);
    }

}
