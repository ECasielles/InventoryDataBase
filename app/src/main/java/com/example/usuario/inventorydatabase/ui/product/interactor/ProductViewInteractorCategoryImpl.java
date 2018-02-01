package com.example.usuario.inventorydatabase.ui.product.interactor;

import com.example.usuario.inventorydatabase.data.db.repository.CategoryRepository;

/**
 * Created by usuario on 1/02/18.
 */

public class ProductViewInteractorCategoryImpl implements ProductViewInteractor.Category {

    ProductViewInteractor.Category.OnCategoryLoadedListener listener;

    public ProductViewInteractorCategoryImpl(ProductViewInteractor.Category.OnCategoryLoadedListener listener) {
        this.listener = listener;
    }

    @Override
    public void loadCategories(int category) {
        listener.onCategoryLoaded(CategoryRepository.getInstance().getCategories().get(category));
    }

}
