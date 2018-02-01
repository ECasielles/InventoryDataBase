package com.example.usuario.inventorydatabase.ui.sector;

import com.example.usuario.inventorydatabase.data.db.model.Sector;

/**
 * Created by icenri on 2/1/18.
 */

public interface ViewSectorInteractor {

    void updateSectors(Sector sector);

    interface OnSectorsUpdatedListener {
        void onSectorsUpdated();
    }

}
