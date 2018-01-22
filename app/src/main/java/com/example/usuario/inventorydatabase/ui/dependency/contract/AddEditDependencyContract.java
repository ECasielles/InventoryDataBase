package com.example.usuario.inventorydatabase.ui.dependency.contract;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.ui.base.BasePresenter;
import com.example.usuario.inventorydatabase.ui.base.BaseView;

import java.io.Serializable;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {

    interface View extends BaseView {
        void navigateToListDependency();
        void setNameEmptyError();
        void setShortNameEmptyError();
        void setShortNameLengthError();
        void setDescriptionEmptyError();
        void setValidateDependencyError();
    }
    interface Presenter extends BasePresenter, Serializable {
        void saveDependency(String name, String shortName, String description, String imageName);
        void editDependency(Dependency dependency, String description);
        @Override
        void onDestroy();
    }

}
