package com.example.usuario.inventorydatabase.ui.product.interactor;

import com.example.usuario.inventorydatabase.data.db.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductListInteractor {

    void loadProductViews();

    interface OnProductLoadedListener {
        void onProductViewsLoaded(ArrayList<ProductView> productViews);
    }

}
