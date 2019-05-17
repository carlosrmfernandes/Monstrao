package database.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import database.db.DBOpenHelper;
import database.model.Modalidades;

public class ModalidadesDAO extends AbstrataDAO{

    private final String[]
    colunas = {
        Modalidades.COLUNA_ID,
        Modalidades.COLUNA_MODALIDAE
    };

    public ModalidadesDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void insert(Modalidades modalidades){

        ContentValues value = new ContentValues();
        value.put(Modalidades.COLUNA_MODALIDAE, modalidades.getModalidade());

        open();

        db.insert(Modalidades.TABELA_NOME, null, value);

        close();

    }

    public int Delete(){
        return 0;
    }

    public int Update(){
        return 0;
    }

    public List<Modalidades> Select(){
        List<Modalidades> modalidade= new ArrayList<>();
        open();
        Cursor cursor= db.query(Modalidades.TABELA_NOME, colunas, null, null, null, null, "_id");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            modalidade.add(CursorToStructure(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (modalidade);
    }
    public final Modalidades CursorToStructure(Cursor cursor){

        Modalidades md= new Modalidades();
        md.setId(cursor.getString(0));
        md.setModalidade(cursor.getString(1));
        return md;
    }
    public boolean SelectAluno(final String id){
        boolean isExist = false;

        open();
        Cursor cursor= db.query(Modalidades.TABELA_NOME, colunas, Modalidades.COLUNA_ID+" = ? and ", new String[]{id}, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            isExist = true;
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (isExist);
    }
}
