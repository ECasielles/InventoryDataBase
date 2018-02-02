package com.example.usuario.inventorydatabase.data.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.provider.BaseColumns;
import android.util.Log;

import com.example.usuario.inventorydatabase.data.db.InventoryContract;
import com.example.usuario.inventorydatabase.data.db.InventoryOpenHelper;
import com.example.usuario.inventorydatabase.data.db.model.Product;
import com.example.usuario.inventorydatabase.data.db.model.ProductView;

import java.util.ArrayList;

/**
 * Created by usuario on 2/02/18.
 */

public class ProductViewDao {


    public ArrayList<ProductView> loadAll() {
        ArrayList<ProductView> productViews = new ArrayList<>();
        SQLiteDatabase db = InventoryOpenHelper.getInstance().openDatabase();

        //rawQuery interpreta el comando usando '?' en la consulta.
        //A medio camino entre SQL y SQLite
        Cursor cursor = db.query(
                InventoryContract.ProductEntry.TABLE_NAME,
                InventoryContract.ProductEntry.ALL_COLUMNS,
                null, null, null, null,
                InventoryContract.ProductEntry.DEFAULT_SORT, null
        );
        if (cursor.moveToFirst()) {
            do {
                productViews.add(new ProductView(new Product(
                                cursor.getInt(0),
                                cursor.getInt(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5),
                                cursor.getInt(6),
                                cursor.getInt(7),
                                cursor.getInt(8),
                                cursor.getInt(9),
                                cursor.getFloat(10),
                                cursor.getString(11),
                                cursor.getInt(12),
                                cursor.getString(13),
                                cursor.getString(14),
                                cursor.getString(15),
                                cursor.getString(16)
                        ))
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        InventoryOpenHelper.getInstance().closeDatabase();
        return productViews;
    }

    public ProductView search(int id) {
        SQLiteDatabase sqLiteDatabase = InventoryOpenHelper.getInstance().openDatabase();
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables(InventoryContract.ProductViewEntry.PRODUCT_INNER);
        sqLiteQueryBuilder.setProjectionMap(InventoryContract.ProductViewEntry.sProductViewProjectionMap);

        //Comprueba si la consulta es correcta
        String sql = sqLiteQueryBuilder.buildQuery(
                InventoryContract.ProductViewEntry.ALL_COLUMNS,
                null, null, null, null,
                null
        );
        Log.i("ProductViewDao", sql);

        String selection = InventoryContract.ProductViewEntry.TABLE_NAME + "." + BaseColumns._ID + "= ?";
        String[] selectionArgs = {"" + id};
        Cursor cursor = sqLiteQueryBuilder.query(
                sqLiteDatabase, InventoryContract.ProductViewEntry.ALL_COLUMNS,
                selection, selectionArgs, null, null, null
        );
        ProductView productView = null;
        if (cursor.moveToFirst()) {
            do {
                productView = new ProductView(
                        cursor.getInt(0),
                        0,
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getInt(5),
                        cursor.getInt(6),
                        cursor.getInt(7),
                        cursor.getInt(8),
                        cursor.getFloat(9),
                        cursor.getString(10),
                        cursor.getInt(11),
                        cursor.getString(12),
                        cursor.getString(13),
                        cursor.getString(14),
                        cursor.getString(15),
                        cursor.getString(16),
                        cursor.getString(17),
                        cursor.getString(18)
                );
            } while (cursor.moveToNext());
        }
        return productView;
    }
}
