package com.example.usuario.inventorydatabase.ui.dependency.contract;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.ui.base.BasePresenter;
import com.example.usuario.inventorydatabase.ui.base.BaseView;

import java.io.Serializable;
import java.util.List;

/**
 * Aglutina distintas interfaces
 */
public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependency(List listDependencyInteractor);

        Dependency getDependency(int position);

        void showDeletedMessage();
        void showMessage(String message);

    }

    interface Presenter extends BasePresenter, Serializable {
        void loadDependencies();

        void deleteDependency(Dependency parcelable);

        @Override
        void onDestroy();

        void setNewSelection(int position);
        void removeSelection(int position);
        void deleteSelection();
        void clearSelection();
        boolean getPositionChecked(int position);

    }

}
