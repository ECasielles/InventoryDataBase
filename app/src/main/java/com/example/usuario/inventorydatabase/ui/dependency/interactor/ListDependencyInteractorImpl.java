package com.example.usuario.inventorydatabase.ui.dependency.interactor;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.data.db.repository.DependencyRepository;
import com.example.usuario.inventorydatabase.utils.Error;

import java.util.ArrayList;

/**
 * Interactor de ListDependencyFragment. Controla la comunicación con el repositorio.
 */
public class ListDependencyInteractorImpl implements ListDependencyInteractor {

    private final OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependency(dependency, this);
    }

    public ArrayList<Dependency> loadDependencies() {
        return DependencyRepository.getInstance().getDependencies();
    }
    @Override
    public void onSuccess() {
        listener.onDependencyDeleted();
    }

    @Override
    public void onError(Error error) {
        listener.onDatabaseError(error);
    }


}
