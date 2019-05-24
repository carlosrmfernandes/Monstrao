package database.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import database.db.DBOpenHelper;
import database.model.MatriculaModalidades;
import database.model.Matriculas;

public class MatriculasDAO extends AbstrataDAO{

    private final String[]
    colunas = {
            Matriculas.COLUNA_ID,
            Matriculas.COLUNA_CODIGOMATICULA,
            Matriculas.COLUNA_CODIGOALUNO,
            Matriculas.COLUNA_DATAMATRICULA,
            Matriculas.COLUNA_DATAVENCIMENTO,
            Matriculas.COLUNA_DATAENCERRAMENTO,
    };

    public MatriculasDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void Insert(Matriculas matriculas){
        ContentValues values = new ContentValues();
        values.put(Matriculas.COLUNA_CODIGOALUNO, matriculas.getCodigo_aluno());
        values.put(Matriculas.COLUNA_CODIGOMATICULA, matriculas.getCodigo_matricula());
        values.put(Matriculas.COLUNA_DATAMATRICULA, matriculas.getData_matricula());

        open();
        db.insert(Matriculas.TABELA_NAME, null, values);
        close();
    }

    public int Delete(){
        return 0;
    }

    public int Update(){
        return 0;
    }

    public List<Matriculas> Select(){
        List<Matriculas> gr= new ArrayList<>();
        open();
        Cursor cursor= db.query(Matriculas.TABELA_NAME, colunas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            gr.add(CursorToStructure(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (gr);
    }
    public final Matriculas CursorToStructure(Cursor cursor){

        Matriculas gr= new Matriculas();
        gr.setCodigo_matricula(Integer.valueOf(cursor.getString(0)));
        gr.setData_matricula(cursor.getString(1));
                return gr;
    }
}
