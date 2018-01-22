package com.example.usuario.inventorydatabase.ui.dependency.interactor;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditDependencyInteractor {

    interface OnAddEditFinishedListener {
        void onNameEmptyError();
        void onShortNameEmptyError();
        void onShortNameLengthError();
        void onDescriptionEmptyError();
        void onSuccess(String name, String shortname, String description, String imageName);
    }

    void validateDependency(String name, String shortname, String description, String imageName);

    void addDependency(String name, String shortname, String description, String imageName);

    void editDependency(Dependency dependency, String description);
}
