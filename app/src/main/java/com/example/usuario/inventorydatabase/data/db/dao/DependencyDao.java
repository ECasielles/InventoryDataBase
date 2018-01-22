package com.example.usuario.inventorydatabase.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.inventorydatabase.data.db.InventoryContract;
import com.example.usuario.inventorydatabase.data.db.model.InventoryOpenHelper;

/**
 * Los DAOs tienen siempre los mismos métodos. Por lo que
 * tienen nombres genéricos.
 */
public class DependencyDao {

    /**
     * Método que devuelve un cursor con todas las dependencias
     * de la BD.
     * Se le podrían pasar todos los parámetros
     * @return
     */
    public Cursor loadAll() {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        //rawQuery interpreta el comando usando '?' en la consulta.
        //A medio camino entre SQL y SQLite
        Cursor cursor = sqLiteDatabase.query(InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMNS,
                null,null,null,null,
                InventoryContract.DependencyEntry.DEFAULT_SORT,null
        );

        //NO SE CIERRA EL CURSOR????
        InventoryOpenHelper.getInstance().closeDatabase();
        return cursor;
    }

}
