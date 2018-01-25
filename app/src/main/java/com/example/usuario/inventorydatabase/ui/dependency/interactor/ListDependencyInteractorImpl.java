package com.example.usuario.inventorydatabase.ui.dependency.interactor;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.data.db.repository.DependencyRepository;
import com.example.usuario.inventorydatabase.utils.Error;

/**
 * Created by usuario on 27/11/17.
 */
public class ListDependencyInteractorImpl implements ListDependencyInteractor {

    private final OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependency(dependency, this);
            //Falta mostrar mensaje cuando se haya eliminado
            listener.onSuccess(DependencyRepository.getInstance().getDependencies());
        //Se le puede pasar al repositorio una interfaz del interactor.
    }

    public void loadDependencies(){
        DependencyRepository.getInstance().getDependencies();
    }

    @Override
    public void onSuccess() {
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void onError(Error error) {
        listener.onDatabaseError(error);
    }

}
