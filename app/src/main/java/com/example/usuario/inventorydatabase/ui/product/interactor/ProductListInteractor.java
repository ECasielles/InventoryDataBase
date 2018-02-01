package com.example.usuario.inventorydatabase.ui.product.interactor;

import com.example.usuario.inventorydatabase.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductListInteractor {

    void loadProducts();

    interface OnProductLoadedListener {
        void onProductsLoaded(ArrayList<Product> products);
    }

}
