package com.example.usuario.inventorydatabase.ui.sector;

import com.example.usuario.inventorydatabase.data.db.model.Sector;
import com.example.usuario.inventorydatabase.data.db.repository.SectorRepository;

/**
 * Created by icenri on 2/1/18.
 */

public class ViewSectorInteractorImpl implements ViewSectorInteractor {
    private OnSectorsUpdatedListener listener;

    public ViewSectorInteractorImpl(ViewSectorInteractor.OnSectorsUpdatedListener listener) {
        this.listener = listener;
    }

    @Override
    public void updateSectors(Sector sector) {
        SectorRepository.getInstance().updateSector(sector);
        listener.onSectorsUpdated();
    }

}
