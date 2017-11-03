package com.food.store.myfoodapp.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.food.store.myfoodapp.Model.Order;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moses on 11/3/2017.
 */

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME = "FoodDB";
    private static final int DB_VERSION = 1;
    public Database(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    public List<Order> getCarts()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        String[] sqlSelect = {"ProductId","ProductName","Quantity","Price","Discount"};
        String sqlTable = "OrderDetail";
        qb.setTables(sqlTable);
        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);

        final List<Order> result = new ArrayList<>();
        if (c.moveToFirst())
        {
            do{
                result.add(new Order(c.getString(c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductName")),
                        c.getString(c.getColumnIndex("Quantity")),
                        c.getString(c.getColumnIndex("Price")),
                        c.getString(c.getColumnIndex("Discpunt"))
                ));
            }while(c.moveToNext());
        }
        return result;
    }

    
}
