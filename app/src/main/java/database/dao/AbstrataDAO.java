package database.dao;

import android.database.sqlite.SQLiteDatabase;

import database.db.DBOpenHelper;

public abstract class AbstrataDAO {

    protected SQLiteDatabase db;
    protected DBOpenHelper db_helper;

    protected  final void open(){
        db = db_helper.getWritableDatabase();
    }

    protected  final void close(){
        db_helper.close();
    }

}
