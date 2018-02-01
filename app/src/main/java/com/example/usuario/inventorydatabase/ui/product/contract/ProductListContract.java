package com.example.usuario.inventorydatabase.ui.product.contract;

import com.example.usuario.inventorydatabase.data.db.model.Product;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductListContract {

    interface View {
        void setPresenter(ProductListContract.Presenter presenter);

        void showProducts(ArrayList<Product> products);
    }

    interface Presenter {
        void loadProducts();
    }

}
