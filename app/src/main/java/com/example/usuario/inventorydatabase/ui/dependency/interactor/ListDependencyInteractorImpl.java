package com.example.usuario.inventorydatabase.ui.dependency.interactor;

import com.example.usuario.inventorydatabase.data.db.InventoryApplication;
import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.data.db.repository.DependencyRepository;

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
        if(DependencyRepository.getInstance().deleteDependency(dependency))
            //Falta mostrar mensaje cuando se haya eliminado
            listener.onSuccess(DependencyRepository.getInstance().getDependencies());
        //Se le puede pasar al repositorio una interfaz del interactor.
    }

    public void loadDependencies(){
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
