package com.example.usuario.inventorydatabase.ui.sector;

import com.example.usuario.inventorydatabase.data.db.model.Sector;

import java.util.ArrayList;


public class ListSectorPresenter implements ListSectorContract.Presenter, ListSectorInteractor.OnSectorsLoadedListener {
    ListSectorContract.View view;
    ListSectorInteractor interactor;

    public ListSectorPresenter(ListSectorContract.View view) {
        this.view = view;
        this.interactor = new ListSectorInteractorImpl(this);
    }

    @Override
    public void loadSectors() {
        interactor.loadSectors();
    }

    @Override
    public void onSectorsLoaded(ArrayList<Sector> sectors) {
        view.showSectors(sectors);
    }

}
