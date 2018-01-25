package com.example.usuario.inventorydatabase.data.db.repository;

import com.example.usuario.inventorydatabase.data.db.dao.SectorDao;
import com.example.usuario.inventorydatabase.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Almacena las distintas secciones donde guardar elementos del inventario
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see Sector
 */
public class SectorRepository {

    private static SectorRepository sectorRepository;

    static {
        sectorRepository = new SectorRepository();
    }

    private SectorDao sectorDao;

    private SectorRepository() {
        sectorDao = new SectorDao();
    }

    public static SectorRepository getInstance(){
        if(sectorRepository == null)
            sectorRepository = new SectorRepository();
        return sectorRepository;
    }

    public ArrayList<Sector> getSectors() {
        return sectorDao.loadAll();
    }

    private void addSector(Sector sector) {
        sectorDao.add(sector);
    }

    private void updateSector(Sector sector) {
        sectorDao.update(sector);
    }

    private void deleteSector(Sector sector) {
        sectorDao.delete(sector);
    }

    private boolean exists(Sector sector) {
        return sectorDao.exists(sector);
    }


}
