package com.example.usuario.inventorydatabase.ui.sector;

import com.example.usuario.inventorydatabase.data.db.model.Sector;

/**
 * Created by icenri on 2/1/18.
 */

public interface ViewSectorContract {

    interface View {
        void setPresenter(ViewSectorContract.Presenter presenter);
        void onSectorsUpdated();
    }

    interface Presenter {
        void addSector(Sector sector);

        void updateSector(Sector sector);
    }

}
