package com.example.usuario.inventorydatabase.ui.product.presenter;

import com.example.usuario.inventorydatabase.data.db.model.Category;
import com.example.usuario.inventorydatabase.data.db.model.ProductClass;
import com.example.usuario.inventorydatabase.ui.product.contract.ProductViewContract;
import com.example.usuario.inventorydatabase.ui.product.interactor.ProductViewInteractor;
import com.example.usuario.inventorydatabase.ui.product.interactor.ProductViewInteractorCategoryImpl;
import com.example.usuario.inventorydatabase.ui.product.interactor.ProductViewInteractorProductClassImpl;


public class ProductViewPresenter implements ProductViewContract.Presenter,
        ProductViewInteractor.Category.OnCategoryLoadedListener,
        ProductViewInteractor.ProductClass.OnProductClassLoadedListener {

    private ProductViewInteractor.Category categoryInteractor;
    private ProductViewInteractor.ProductClass productClassInteractor;
    private ProductViewContract.View view;

    public ProductViewPresenter(ProductViewContract.View view) {
        this.view = view;
        this.categoryInteractor = new ProductViewInteractorCategoryImpl(this);
        this.productClassInteractor = new ProductViewInteractorProductClassImpl(this);
    }

    @Override
    public void loadCategories(int category) {
        categoryInteractor.loadCategories(category);
    }

    @Override
    public void loadProductClasses(int productClass) {
        productClassInteractor.loadProductClasses(productClass);
    }

    @Override
    public void onCategoryLoaded(Category categories) {
        view.saveCategories(categories);
    }

    @Override
    public void onProductClassLoaded(ProductClass productClass) {
        view.saveProductClasses(productClass);
    }

}
