package com.example.usuario.inventorydatabase.ui.sector;

import com.example.usuario.inventorydatabase.data.db.model.Sector;

/**
 * Created by icenri on 2/1/18.
 */

public interface ViewSectorInteractor extends SectorRepositoryCallback {

    void updateSectors(Sector sector);

    void addSector(Sector sector);

    interface OnSectorsUpdatedListener {
        void onSectorsUpdated();
    }

}
