package com.example.usuario.inventorydatabase.ui.product.presenter;

import com.example.usuario.inventorydatabase.data.db.model.ProductView;
import com.example.usuario.inventorydatabase.ui.product.contract.ProductListContract;
import com.example.usuario.inventorydatabase.ui.product.interactor.ProductListInteractor;
import com.example.usuario.inventorydatabase.ui.product.interactor.ProductListInteractorImpl;

import java.util.ArrayList;

public class ProductListPresenter implements ProductListContract.Presenter, ProductListInteractor.OnProductLoadedListener {
    private ProductListContract.View view;
    private ProductListInteractor interactor;

    public ProductListPresenter(ProductListContract.View view) {
        this.view = view;
        this.interactor = new ProductListInteractorImpl(this);
    }

    @Override
    public void loadProductViews() {
        interactor.loadProductViews();
    }

    @Override
    public void onProductViewsLoaded(ArrayList<ProductView> productViews) {
        view.showProductViews(productViews);
    }

}
