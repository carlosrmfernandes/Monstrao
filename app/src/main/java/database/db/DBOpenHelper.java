package database.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import database.model.Alunos;
import database.model.Usuarios;

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String
    DATABASE_NOME = "banco.db";

    private static final int
    DATABASE_VERSAO = 6;

    public DBOpenHelper(Context context){
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(Usuarios.CREAT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        if (newVersion > 5) {
            db.execSQL(Alunos.CREATE_TABLE);
        }
        else {
            db.execSQL(Usuarios.CREAT_TABLE);
        }
    }
}
