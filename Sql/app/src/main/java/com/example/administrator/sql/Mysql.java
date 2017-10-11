package com.example.administrator.sql;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Mysql extends SQLiteOpenHelper {

    public Mysql(Context context){
        this(context,"ss",null,1);
    }

    public Mysql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version,null);
    }

    public Mysql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, "test.db", null, 1, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table student(_id integer primary key autoincrement ,name varchar(20),age integer,sex varchar(10))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
