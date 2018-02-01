package com.example.usuario.inventorydatabase.ui.product.interactor;


public interface ProductViewInteractor {

    interface Category {
        void loadCategories(int category);

        interface OnCategoryLoadedListener {
            void onCategoryLoaded(com.example.usuario.inventorydatabase.data.db.model.Category categories);
        }
    }

    interface ProductClass {
        void loadProductClasses(int productClass);

        interface OnProductClassLoadedListener {
            void onProductClassLoaded(com.example.usuario.inventorydatabase.data.db.model.ProductClass productClass);
        }
    }

}
