package com.example.usuario.inventorydatabase.data.db.model;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.example.usuario.inventorydatabase.data.db.InventoryApplication;
import com.example.usuario.inventorydatabase.data.db.InventoryContract;

/**
 * Clase que trabaja con la BD.
 */

public class InventoryOpenHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static InventoryOpenHelper helper;
    private SQLiteDatabase sqLiteDatabase;

    public InventoryOpenHelper() {
        //Se le pasa el CONTEXTO de la APLICACION
        //No usamos factory porque no usamos el patrón Factory para varios Contract
        super(InventoryApplication.getContext(), InventoryContract.DATABASE_NAME,
                null, InventoryContract.DATABASE_VERSION);
    }

    public static InventoryOpenHelper getInstance() {
        if(helper == null)
            helper = new InventoryOpenHelper();
        return helper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Si lo hacemos con Transaction, no se va a crear nada si no está perfecto.
        //Nos daremos cuenta del error cuando no se cree algo.
        //Por eso en principio no usaremos atomicidad.
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_INSERT_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_CREATE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_INSERT_ENTRIES);
    }

    /**
     * TODO: IMPLEMENTAR VERSIONES
     * Tiene que
     * @param sqLiteDatabase
     * @param i
     * @param i1
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //IMPORTANTE: A la hora de eliminar hay que tener en cuenta el orden por
        //claves ajenas.
        sqLiteDatabase.execSQL(InventoryContract.DependencyEntry.SQL_DELETE_ENTRIES);
        sqLiteDatabase.execSQL(InventoryContract.SectorEntry.SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);

    }

    public void openDatabase() {
        //Aquí es cuando se crean las llamadas callback y diferentes métodos
        //Se crea y/o abre la Bd.
        sqLiteDatabase = getWritableDatabase();
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if(!db.isReadOnly())
            //Para no tener que declarar cada sentencia con PRAGMA con claves ajenas
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN)
                db.setForeignKeyConstraintsEnabled(true);
            else
                db.execSQL("PRAGMA foreign_keys=1");
    }

}
