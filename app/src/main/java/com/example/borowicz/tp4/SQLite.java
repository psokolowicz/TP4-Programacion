package com.example.borowicz.tp4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 42374778 on 8/6/2017.
 */
public class SQLite extends SQLiteOpenHelper {

    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String consulta;
        consulta = "create table usuarios (usuario text, pass text)";
        db.execSQL(consulta);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
