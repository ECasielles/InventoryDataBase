package com.example.usuario.inventorydatabase.ui.dependency.interactor;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {

    void deleteDependency(Dependency dependency);

    interface OnLoadFinishedListener {
        void onSuccess(List<Dependency> dependencies);
    }

    void loadDependencies();
}
