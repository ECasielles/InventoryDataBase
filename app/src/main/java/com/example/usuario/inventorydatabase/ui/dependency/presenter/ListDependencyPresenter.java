package com.example.usuario.inventorydatabase.ui.dependency.presenter;

import android.os.AsyncTask;

import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventorydatabase.ui.dependency.interactor.ListDependencyInteractor;
import com.example.usuario.inventorydatabase.ui.dependency.interactor.ListDependencyInteractorImpl;
import com.example.usuario.inventorydatabase.utils.Error;

import java.util.HashMap;
import java.util.List;


public class ListDependencyPresenter implements ListDependencyContract.Presenter,
        ListDependencyInteractor.OnLoadFinishedListener {
    public static final String TAG = "ListDependencyPresenter";
    //COMUNICACION CON MENU SELECCION MULTIPLE
    HashMap<Integer, Boolean> selection = new HashMap<>();
    private ListDependencyContract.View view;
    private ListDependencyInteractorImpl interactor;

    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.interactor = new ListDependencyInteractorImpl(this);
    }

    @Override
    public void loadDependencies() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                view.showProgressDialog();
            }

            @Override
            protected Void doInBackground(Void... voids) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                interactor.loadDependencies();
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                view.dismissProgressDialog();
            }
        }.execute();
    }

    @Override
    public void onSuccess(List<Dependency> dependencies) {
        view.showDependency(dependencies);
    }
    @Override
    public void deleteDependency(Dependency dependency) {
        interactor.deleteDependency(dependency);
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

}
