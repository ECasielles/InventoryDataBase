package com.example.usuario.inventorydatabase.data.db.repository;

import com.example.usuario.inventorydatabase.data.db.dao.ProductDao;
import com.example.usuario.inventorydatabase.data.db.dao.ProductViewDao;
import com.example.usuario.inventorydatabase.data.db.model.Product;
import com.example.usuario.inventorydatabase.data.db.model.ProductView;

import java.util.ArrayList;

public class ProductRepository {

    private static ProductRepository productRepository;

    static {
        productRepository = new ProductRepository();
    }

    private ProductDao productDao;
    private ProductViewDao productViewDao;

    private ProductRepository() {
        productDao = new ProductDao();
        productViewDao = new ProductViewDao();
    }


    public static ProductRepository getInstance() {
        if (productRepository == null)
            productRepository = new ProductRepository();
        return productRepository;
    }

    public ArrayList<Product> getProducts() {
        return productDao.loadAll();
    }

    public ArrayList<ProductView> getProductViews() {
        return productViewDao.loadAll();
    }

    public ProductView search(int id) {
        return productViewDao.search(id);
    }

}
