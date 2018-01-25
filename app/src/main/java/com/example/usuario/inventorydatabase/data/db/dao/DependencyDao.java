package com.example.usuario.inventorydatabase.data.db.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.example.usuario.inventorydatabase.data.db.InventoryContract;
import com.example.usuario.inventorydatabase.data.db.InventoryOpenHelper;
import com.example.usuario.inventorydatabase.data.db.model.Dependency;

import java.util.ArrayList;

/**
 * Los DAOs tienen siempre los mismos métodos. Por lo que
 * tienen nombres genéricos.
 * Este Dao hace todas las operaciones de tabla en la Base de Datos.
 */
//TODO: Meterle un hilo, AsyncTask o con cargadores (pero matan el MVP)
//Los puristas usan hilos porque AsyncTask trabaja con la vista
public class DependencyDao {
    ArrayList<Dependency> dependencies;

    /**
     * Método que devuelve un cursor con todas las dependencias
     * de la BD.
     * Se le podrían pasar todos los parámetros
     * @return
     */
    //public Observable<ArrayList<Dependency>> loadAll() <-- Usando ReactiveX
    public ArrayList<Dependency> loadAll() {
        /*ArrayList<Dependency> dependencies = new ArrayList<>();
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
        InventoryOpenHelper.getInstance().closeDatabase();*/
        new LoadDependencyListAsyncTask().execute();
        return dependencies;
    }

    /**
     * Método que añade una dependencia en la base de datos
     * @param dependency Dependencia que se añade
     * @return Devuelve el id del nuevo elemento que se ha insertado
     */
    public long add(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        //nullColumnHack crea filas sólo con id para evitar errores
        //por clave ajena, pero no lo vamos a usar
        long id = sqLiteDatabase.insert(
                InventoryContract.DependencyEntry.TABLE_NAME,
                null,
                createContent(dependency)
        );
        InventoryOpenHelper.getInstance().closeDatabase();
        return id;
    }

    public int delete(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        String[] whereArgs = new String[]{dependency.get_ID() + ""};
        return sqLiteDatabase.delete(
          InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.WHERE_ID,
                whereArgs
        );
    }

    public boolean exists(String name, String shortname) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        return DatabaseUtils.queryNumEntries(sqLiteDatabase,
                InventoryContract.DependencyEntry.TABLE_NAME,
                InventoryContract.DependencyEntry.WHERE_NAME_AND_SHORTNAME,
                new String[]{name, shortname}) > 0;
    }

    public int update(Dependency dependency) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        String[] whereArgs = new String[]{"" + dependency.get_ID()};
        int updatedRows = sqLiteDatabase.update(
                InventoryContract.DependencyEntry.TABLE_NAME,
                createContent(dependency),
                InventoryContract.DependencyEntry.WHERE_ID,
                whereArgs
        );
        InventoryOpenHelper.getInstance().closeDatabase();
        return updatedRows;
    }


    public ContentValues createContent(Dependency dependency) {
        //ContentValues funciona como un mapa
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_NAME, dependency.getName());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_SHORTNAME, dependency.getShortname());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_DESCRIPTION, dependency.getDescription());
        contentValues.put(InventoryContract.DependencyEntry.COLUMN_IMAGENAME, dependency.getImageName());
        return contentValues;
    }


    class LoadDependencyListAsyncTask extends AsyncTask<Void, Dependency, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            dependencies = new ArrayList<>();
            SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
            //rawQuery interpreta el comando usando '?' en la consulta.
            //A medio camino entre SQL y SQLite
            Cursor cursor = sqLiteDatabase.query(
                    InventoryContract.DependencyEntry.TABLE_NAME,
                    InventoryContract.DependencyEntry.ALL_COLUMNS,
                    null, null, null, null,
                    InventoryContract.DependencyEntry.DEFAULT_SORT, null
            );
            if (cursor.moveToFirst()) {
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

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Dependency[] values) {
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }

}
