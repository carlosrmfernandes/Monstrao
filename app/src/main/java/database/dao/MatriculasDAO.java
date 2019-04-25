package database.dao;


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

    public int Insert(){
        return 0;
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
