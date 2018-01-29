package com.example.usuario.inventorydatabase.ui.dependency.presenter;

import android.os.AsyncTask;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventorydatabase.ui.dependency.interactor.ListDependencyInteractor;
import com.example.usuario.inventorydatabase.ui.dependency.interactor.ListDependencyInteractorImpl;
import com.example.usuario.inventorydatabase.utils.Error;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListDependencyPresenter implements ListDependencyContract.Presenter,
        ListDependencyInteractor.OnLoadFinishedListener {
    public static final String TAG = "ListDependencyPresenter";

    //AsyncTask method codes
    private static final int NONE = 0;
    private static final int DELETE = 1;

    //COMUNICACION CON MENU SELECCION MULTIPLE
    HashMap<Integer, Boolean> selection = new HashMap<>();
    private ListDependencyContract.View view;
    private ListDependencyInteractor interactor;


    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.interactor = new ListDependencyInteractorImpl(this);
    }

    @Override
    public void loadDependencies() {
        view.showProgressDialog();
        new ListDependencyInteractorAsyncTask(this, interactor, NONE).execute();
    }

    @Override
    public void onDependenciesLoaded(List<Dependency> dependencies) {
        view.dismissProgressDialog();
        view.showDependencies(dependencies);
    }
    @Override
    public void deleteDependency(Dependency dependency) {
        //TODO: Preguntar si se elimina y se recarga todo en una misma operación
        interactor.deleteDependency(dependency);
    }

    @Override
    public void onDependencyDeleted() {
        view.showProgressDialog();
        new ListDependencyInteractorAsyncTask(this, interactor, DELETE).execute();
    }

    private void showDeletedMessage() {
        view.showDeletedMessage();
    }

    @Override
    public void onDatabaseError(Error error) {
        view.showMessage(error.getMessage());
    }

    @Override
    public void setNewSelection(int position) {
        selection.put(position, true);
    }
    @Override
    public void removeSelection(int position) {
        selection.remove(position);
    }
    @Override
    public void clearSelection() {
        selection.clear();
    }
    @Override
    public void deleteSelection() {
        for (Integer position: selection.keySet())
            deleteDependency(view.getDependency(position));
    }
    @Override
    public boolean getPositionChecked(int position) {
        return selection.containsKey(position);
    }

    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

    private static class ListDependencyInteractorAsyncTask extends AsyncTask<Void, Void, Void> {
        private ListDependencyInteractor interactor;
        private ListDependencyPresenter listDependencyPresenter;
        private ArrayList<Dependency> dependencies;
        private int actionCode;

        private ListDependencyInteractorAsyncTask(ListDependencyPresenter listDependencyPresenter, ListDependencyInteractor interactor, int actionCode) {
            this.listDependencyPresenter = listDependencyPresenter;
            this.dependencies = new ArrayList<>();
            this.interactor = interactor;
            this.actionCode = actionCode;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            dependencies = interactor.loadDependencies();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            //TODO: Si hay un error no puede pasar por onDependenciesLoaded. Controlar los errores de BD?
            listDependencyPresenter.onDependenciesLoaded(dependencies);
            //TODO: Preguntar a Lourdes si se puede hacer sin if/switch
            if (actionCode == DELETE)
                listDependencyPresenter.showDeletedMessage();
        }

    }


}
