package com.example.usuario.inventorydatabase.ui.sector;

import com.example.usuario.inventorydatabase.data.db.model.Sector;

/**
 * Created by icenri on 2/1/18.
 */

public class ViewSectorPresenter implements ViewSectorContract.Presenter, ViewSectorInteractor.OnSectorsUpdatedListener {

    private ViewSectorContract.View view;
    private ViewSectorInteractor interactor;

    public ViewSectorPresenter(ViewSectorContract.View view) {
        this.view = view;
        this.interactor = new ViewSectorInteractorImpl(this);
    }

    @Override
    public void updateSectors(Sector sector) {
        interactor.updateSectors(sector);
    }

    @Override
    public void onSectorsUpdated() {
        view.onSectorsUpdated();
    }
}
