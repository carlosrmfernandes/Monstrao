package database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import database.db.DBOpenHelper;
import database.model.Graduacoes;

public class GraduacoesDAO extends  AbstrataDAO{

    private final String [] colunas =
            {
                    Graduacoes.GRADUACAO,
                    Graduacoes.MODALIDADE,
                    Graduacoes.COLUNA_ID,
            };
    public  GraduacoesDAO (Context ao_Context){
        db_helper = new DBOpenHelper(ao_Context);
    }

    public void Insert(Graduacoes graduacoes){
        ContentValues value = new ContentValues();
        value.put(Graduacoes.GRADUACAO, graduacoes.getGraduacao());
        value.put(Graduacoes.MODALIDADE, graduacoes.getModalidade());

        open();

        db.insert(Graduacoes.TABELA_NOME, null,value);

        close();
    }
    public int Delete(){
        return 0;
    }
    public int Update(){
        return 0;
    }
    public List<Graduacoes> Select(){
        List<Graduacoes> gr= new ArrayList<>();
        open();
        Cursor cursor= db.query(Graduacoes.TABELA_NOME, colunas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            gr.add(CursorToStructure(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (gr);
    }
    public final Graduacoes CursorToStructure(Cursor cursor){

        Graduacoes gr= new Graduacoes();
        gr.setId(cursor.getString(0));
        gr.setModalidade(cursor.getString(1));
        gr.setGraduacao(cursor.getString(2));
        return gr;
    }
    public boolean SelectAluno(final String id){
        boolean isExist = false;

        open();
        Cursor cursor= db.query(Graduacoes.TABELA_NOME, colunas, Graduacoes.COLUNA_ID+" = ? and ", new String[]{id}, null, null, null);
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
