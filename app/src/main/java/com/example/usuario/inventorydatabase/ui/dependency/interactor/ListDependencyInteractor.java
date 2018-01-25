package com.example.usuario.inventorydatabase.ui.dependency.interactor;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.utils.Error;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor extends DependencyCallback {

    void deleteDependency(Dependency dependency);

    void loadDependencies();

    interface OnLoadFinishedListener {
        void onSuccess(List<Dependency> dependencies);

        void onDatabaseError(Error error);
    }
}
