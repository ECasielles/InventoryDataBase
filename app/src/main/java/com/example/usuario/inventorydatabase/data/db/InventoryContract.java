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
        public static final String WHERE_ID = String.format(
                "%s = ?",
                BaseColumns._ID
        );
        public static final String WHERE_NAME_AND_SHORTNAME = String.format(
                "%s = ? AND %s = ?",
                COLUMN_NAME,
                COLUMN_SHORTNAME
        );

        public static final String DEFAULT_SORT = COLUMN_NAME;

        //Hay dos opciones
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT)",
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
        ) + String.format("('%s', '%s', '%s', '%s'),",
                "Aula de 1CFGS",
                "1CFGS",
                "Aula de los pardillos de 1CFGS",
                "sin imagen"
        ) + String.format("('%s', '%s', '%s', '%s'),",
                "Aula de TEST",
                "1CFGS",
                "Aula de los pardillos de 1CFGS",
                "sin imagen"
        ) + String.format("('%s', '%s', '%s', '%s'),",
                "Aula de TEST",
                "1CFGS",
                "Aula de los pardillos de 1CFGS",
                "sin imagen"
        ) + String.format("('%s', '%s', '%s', '%s'),",
                "Aula de TEST",
                "1CFGS",
                "Aula de los pardillos de 1CFGS",
                "sin imagen"
        ) + String.format("('%s', '%s', '%s', '%s')",
                "Aula de TEST",
                "1CFGS",
                "Aula de los pardillos de 1CFGS",
                "sin imagen"
        );

    }

    public static class SectorEntry implements BaseColumns {

        public static final String TABLE_NAME = "sector";
        public static final String COLUMN_DEPENDENCY_ID = "sectorId";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_IMAGEBASE64 = "imageBase64";
        public static final String COLUMN_IMAGENAME = "imageName";

        public static final String REFERENCES_DEPENDENCY_ID = String.format(
                "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT",
                COLUMN_DEPENDENCY_ID, DependencyEntry.TABLE_NAME, BaseColumns._ID
        );

        //En el mismo orden que las declaramos
        public static final String[] ALL_COLUMNS = new String[] {
                BaseColumns._ID, COLUMN_DEPENDENCY_ID, COLUMN_NAME, COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION, COLUMN_IMAGEBASE64, COLUMN_IMAGENAME
        };

        public static final String DEFAULT_SORT = COLUMN_NAME;

        //Hay dos opciones
        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s INTEGER NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s)",
                TABLE_NAME,
                BaseColumns._ID,
                COLUMN_DEPENDENCY_ID,
                COLUMN_NAME,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_IMAGEBASE64,
                COLUMN_IMAGENAME,
                REFERENCES_DEPENDENCY_ID
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

    public static class ProductEntry implements BaseColumns {

        public static final String TABLE_NAME = "product";
        public static final String COLUMN_DEPENDENCY_ID = "productId";
        public static final String COLUMN_SERIAL = "serial";
        public static final String COLUMN_MODEL_CODE = "modelCode";
        public static final String COLUMN_SHORTNAME = "shortname";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_PRODUCT_CLASS = "productClass";
        public static final String COLUMN_SECTOR_ID = "sectorID";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_VALUE = "value";
        public static final String COLUMN_VENDOR = "vendor";
        public static final String COLUMN_BITMAP = "bitmap";
        public static final String COLUMN_IMAGENAME = "imageName";
        public static final String COLUMN_URL = "url";
        public static final String COLUMN_DATE_PURCHASE = "datePurchase";
        public static final String COLUMN_NOTES = "notes";

        public static final String REFERENCES_CATEGORY_ID = String.format(
                "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT",
                COLUMN_CATEGORY, CategoryEntry.TABLE_NAME, BaseColumns._ID
        );
        public static final String REFERENCES_PRODUCT_CLASS_ID = String.format(
                "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT",
                COLUMN_PRODUCT_CLASS, ProductClassEntry.TABLE_NAME, BaseColumns._ID
        );
        public static final String REFERENCES_SECTOR_ID = String.format(
                "FOREIGN KEY (%s) REFERENCES %s(%s) ON UPDATE CASCADE ON DELETE RESTRICT",
                COLUMN_SECTOR_ID, SectorEntry.TABLE_NAME, BaseColumns._ID
        );

        //En el mismo orden que las declaramos
        public static final String[] ALL_COLUMNS = new String[]{
                BaseColumns._ID,
                COLUMN_DEPENDENCY_ID,
                COLUMN_SERIAL,
                COLUMN_MODEL_CODE,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_CATEGORY,
                COLUMN_PRODUCT_CLASS,
                COLUMN_SECTOR_ID,
                COLUMN_QUANTITY,
                COLUMN_VALUE,
                COLUMN_VENDOR,
                COLUMN_BITMAP,
                COLUMN_IMAGENAME,
                COLUMN_URL,
                COLUMN_DATE_PURCHASE,
                COLUMN_NOTES
        };

        public static final String DEFAULT_SORT = COLUMN_SERIAL;

        public static final String SQL_CREATE_ENTRIES = String.format(
                "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "%s INTEGER NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s REAL NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s INTEGER NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s TEXT NOT NULL, " +
                        "%s," +
                        "%s," +
                        "%s," +
                        ")",
                TABLE_NAME, BaseColumns._ID,
                COLUMN_DEPENDENCY_ID,
                COLUMN_SERIAL,
                COLUMN_MODEL_CODE,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_CATEGORY,
                COLUMN_PRODUCT_CLASS,
                COLUMN_SECTOR_ID,
                COLUMN_QUANTITY,
                COLUMN_VALUE,
                COLUMN_VENDOR,
                COLUMN_BITMAP,
                COLUMN_IMAGENAME,
                COLUMN_URL,
                COLUMN_DATE_PURCHASE,
                COLUMN_NOTES,
                REFERENCES_CATEGORY_ID,
                REFERENCES_PRODUCT_CLASS_ID,
                REFERENCES_SECTOR_ID
        );

        public static final String SQL_DELETE_ENTRIES = String.format(
                "DROP TABLE IF EXISTS %s", TABLE_NAME);

        public static final String SQL_INSERT_ENTRIES = String.format(
                "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s', '%s'),", TABLE_NAME,
                COLUMN_DEPENDENCY_ID,
                COLUMN_SERIAL,
                COLUMN_MODEL_CODE,
                COLUMN_SHORTNAME,
                COLUMN_DESCRIPTION,
                COLUMN_CATEGORY,
                COLUMN_PRODUCT_CLASS,
                COLUMN_SECTOR_ID,
                COLUMN_QUANTITY,
                COLUMN_VALUE,
                COLUMN_VENDOR,
                COLUMN_BITMAP,
                COLUMN_IMAGENAME,
                COLUMN_URL,
                COLUMN_DATE_PURCHASE,
                COLUMN_NOTES,
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

    public static class ProductClassEntry implements BaseColumns {
        public static final String TABLE_NAME = "productClass";
    }

    public static class CategoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "category";
    }

}
