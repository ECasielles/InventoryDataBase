package com.example.usuario.inventorydatabase.data.db;

import android.provider.BaseColumns;

/**
 *
 * No se puede instanciar ni heredar de ella
 */
public final class InventoryContract {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Inventory.db";
    //Constructor privado para que no sea instanciada
    private InventoryContract() { }

    //Por cada tabla se crea una clase que implementa la interfaz BaseColumns
    //y garantiza que ya exista la columna id
    public static class DependencyEntry implements BaseColumns {

        public static final String TABLE_NAME = "dependency";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGENAME = "imageName";

        //En el mismo orden que las declaramos
        public static final String[] ALL_COLUMNS = new String[] {
                BaseColumns._ID, COLUMN_NAME, COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION, COLUMN_IMAGENAME
        };
        //Hay dos opciones
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME
        );
        public static final String SQL_DELETE_ENTRIES = String.format(
                "DROP TABLE IF EXISTS %s", TABLE_NAME);
        public static final String SQL_INSERT_ENTRIES = String.format(
                "INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s'),", TABLE_NAME,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGENAME,
                "AUla de 2CFGS",
                "2CFGS",
                "Aula de los resopladores de 2CFGS",
                "sin imagen"
        ) + String.format("('%s', '%s', '%s', '%s')",
                "Aula de 1CFGS",
                "1CFGS",
                "Aula de los pardillos de 1CFGS",
                "sin imagen"
        );

    }

    public static class SectorEntry implements BaseColumns {

        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_DEPENDENCY_ID = "dependencyId";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGEBASE64 = "imageBase64";
        public static final String COLUMN_IMAGENAME = "imageName";

        public static final String REFERENCES = String.format(
                "REFERENCES %s(%s), ON UPDATE CASCADE ON DELETE RESTRICT",
                DependencyEntry.TABLE_NAME, BaseColumns._ID
        );

        //En el mismo orden que las declaramos
        public static final String[] ALL_COLUMNS = new String[] {
                BaseColumns._ID, COLUMN_DEPENDENCY_ID, COLUMN_NAME, COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION, COLUMN_IMAGEBASE64, COLUMN_IMAGENAME
        };
        //Hay dos opciones
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s INTEGER NOT NULL" +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL %s)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_DEPENDENCY_ID, BaseColumns._ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGEBASE64,
                COLUMN_IMAGENAME, REFERENCES
        );
        public static final String SQL_DELETE_ENTRIES = String.format(
                "DROP TABLE IF EXISTS %s", TABLE_NAME);
        public static final String SQL_INSERT_ENTRIES = String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s', '%s'),", TABLE_NAME,
                COLUMN_DEPENDENCY_ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGEBASE64,
                COLUMN_IMAGENAME,
                1,
                "Armario Izquierda del aula de DAM1",
                "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                "sin imagen",
                "sin imagen"
        ) + String.format("('%s', '%s', '%s', '%s', '%s', '%s')",
                2,
                "Armario Izquierda del aula de DAM2",
                "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                "sin imagen",
                "sin imagen"
        );

    }

}
