package com.example.usuario.inventorydatabase.ui.product.interactor;

import com.example.usuario.inventorydatabase.data.db.repository.ProductClassRepository;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductViewInteractorProductClassImpl implements ProductViewInteractor.ProductClass {

    ProductViewInteractor.ProductClass.OnProductClassLoadedListener listener;

    public ProductViewInteractorProductClassImpl(OnProductClassLoadedListener listener) {
        this.listener = listener;
    }

    @Override
    public void loadProductClasses(int productClass) {
        listener.onProductClassLoaded(ProductClassRepository.getInstance().getProductClasses().get(productClass));
    }

}
