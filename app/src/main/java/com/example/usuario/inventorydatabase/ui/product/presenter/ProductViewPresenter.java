package com.example.usuario.inventorydatabase.ui.product.presenter;

import com.example.usuario.inventorydatabase.ui.product.contract.ProductViewContract;
import com.example.usuario.inventorydatabase.ui.product.interactor.ProductViewInteractor;
import com.example.usuario.inventorydatabase.ui.product.interactor.ProductViewInteractorImpl;


public class ProductViewPresenter implements ProductViewContract.Presenter,
        ProductViewInteractor.OnProducViewLoadedListener {

    private ProductViewContract.View view;
    private ProductViewInteractor interactor;

    public ProductViewPresenter(ProductViewContract.View view) {
        this.view = view;
        this.interactor = new ProductViewInteractorImpl(this);
    }

}
