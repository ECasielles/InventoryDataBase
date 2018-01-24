package com.example.usuario.inventorydatabase.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.usuario.inventorydatabase.data.db.InventoryContract;
import com.example.usuario.inventorydatabase.data.db.model.Dependency;
import com.example.usuario.inventorydatabase.data.db.model.InventoryOpenHelper;

import java.util.ArrayList;

/**
 * Los DAOs tienen siempre los mismos métodos. Por lo que
 * tienen nombres genéricos.
 * Este Dao hace todas las operaciones de tabla en la Base de Datos.
 */
public class DependencyDao {

    ArrayList<Dependency> dependencies = new ArrayList<>();

    /**
     * Método que devuelve un cursor con todas las dependencias
     * de la BD.
     * Se le podrían pasar todos los parámetros
     * @return
     */
    //public Observable<ArrayList<Dependency>> loadAll() <-- Usando ReactiveX
    public ArrayList<Dependency> loadAll() {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        //rawQuery interpreta el comando usando '?' en la consulta.
        //A medio camino entre SQL y SQLite
        Cursor cursor = sqLiteDatabase.query(
                InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.ALL_COLUMNS,
                null,null,null,null,
                InventoryContract.DependencyEntry.DEFAULT_SORT,null
        );
        if(cursor.moveToFirst()) {
            do {
                dependencies.add(new Dependency(
                        cursor.getInt(0),
                        cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4))
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        InventoryOpenHelper.getInstance().closeDatabase();
        return dependencies;
    }

    /**
     * Método que añade una dependencia en la base de datos
     * @param dependency Dependencia que se añade
     * @return Devuelve el id del nuevo elemento que se ha insertado
     */
    public long save(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        //ContentValues funciona como un mapa
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getShortname());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());

        //nullColumnHack crea filas sólo con id para evitar errores
        //por clave ajena, pero no lo vamos a usar
        long id = sqLiteDatabase.insert(
                InventoryContract.DependencyEntry.TABLE_NAME,
                null,
                contentValues
        );
        InventoryOpenHelper.getInstance().closeDatabase();
        return id;
    }

    public void delete(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        /*sqLiteDatabase.delete(
          InventoryContract.DependencyEntry.TABLE_NAME,
                "ID = " + dependency.get_ID(),

        );*/

    }

    public boolean exists(String name, String shortname) {
        return false;
    }
}
