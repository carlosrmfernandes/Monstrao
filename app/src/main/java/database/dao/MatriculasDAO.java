package database.dao;


import android.content.ContentValues;
import android.content.Context;

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

    public List<MatriculasDAO> Select(){
        return null;
    }
}
