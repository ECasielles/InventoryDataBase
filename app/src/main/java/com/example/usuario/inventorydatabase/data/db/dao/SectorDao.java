package com.example.usuario.inventorydatabase.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.inventorydatabase.data.db.InventoryContract;
import com.example.usuario.inventorydatabase.data.db.InventoryOpenHelper;
import com.example.usuario.inventorydatabase.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 25/01/18.
 */
public class SectorDao {

    public ArrayList<Sector> loadAll() {
        ArrayList<Sector> sectors = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        Cursor cursor = sqLiteDatabase.query(
                InventoryContract.SectorEntry.TABLE_NAME,
                InventoryContract.SectorEntry.ALL_COLUMNS,
                null, null, null, null,
                InventoryContract.SectorEntry.DEFAULT_SORT, null
        );
        if (cursor.moveToFirst()) {
            do {
                sectors.add(
                        new Sector(
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5),
                                false,
                                false
                        )
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        InventoryOpenHelper.getInstance().closeDatabase();
        return sectors;
    }

    public void add(Sector sector) {

    }

    public void update(Sector sector) {

    }

}
