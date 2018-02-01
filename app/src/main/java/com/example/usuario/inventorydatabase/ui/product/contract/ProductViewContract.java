package com.example.usuario.inventorydatabase.ui.product.contract;

import com.example.usuario.inventorydatabase.data.db.model.Category;
import com.example.usuario.inventorydatabase.data.db.model.ProductClass;

/**
 * Created by usuario on 1/02/18.
 */

public interface ProductViewContract {

    interface View {
        void setPresenter(ProductViewContract.Presenter presenter);

        void saveCategories(Category category);

        void saveProductClasses(ProductClass productClass);
    }

    interface Presenter {
        void loadCategories(int category);

        void loadProductClasses(int productClass);

        void onProductClassLoaded(ProductClass productClass);
    }

}
