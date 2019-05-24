package database.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import database.db.DBOpenHelper;
import database.model.Modalidades;
import database.model.Planos;

public class PlanosDAO extends AbstrataDAO{

    private final String[]
    colunas = {
        Planos.COLUNA_ID,
        Planos.COLUNA_MODALIDAE,
        Planos.COLUNA_PLANO,
        Planos.COLUNA_VALORMENSAL
    };

    public PlanosDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void Insert(Planos planos){

        ContentValues value = new ContentValues();
        value.put(Planos.COLUNA_MODALIDAE, planos.getModalidade());
        value.put(Planos.COLUNA_PLANO, planos.getPlano());
        value.put(Planos.COLUNA_VALORMENSAL, planos.getValor_mensal());

        open();

        db.insert(Planos.TABELA_NOME, null,value);

        close();
    }
    public int Delete(){
        return 0;
    }

    public int Update(){
        return 0;
    }

    public List<Planos> Select(){
        List<Planos> pl= new ArrayList<>();
        open();
        Cursor cursor= db.query(Planos.TABELA_NOME, colunas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            pl.add(CursorToStructure(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (pl);
    }
    public final Planos CursorToStructure(Cursor cursor){

        Planos gr= new Planos();

        gr.setId(cursor.getString(0));
        gr.setModalidade(cursor.getString(1));
        gr.setPlano(cursor.getString(2));
        gr.setValor_mensal(cursor.getDouble(3));
        return gr;
    }
    public boolean SelectAluno(final String id){
        boolean isExist = false;

        open();
        Cursor cursor= db.query(Planos.TABELA_NOME, colunas, Planos.COLUNA_ID+" = ? and ", new String[]{id}, null, null, null);
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
