package database.dao;


import android.content.Context;

import java.util.List;

import database.db.DBOpenHelper;
import database.model.MatriculaModalidades;

public class MatriculaModalidadesDAO extends AbstrataDAO{

    private final String[]
    colunas = {
        MatriculaModalidades.COLUNA_ID,
        MatriculaModalidades.COLUNA_CODIGO_MATRICULA,
        MatriculaModalidades.COLUNA_MODALIDADE,
        MatriculaModalidades.COLUNA_PLANO,
        MatriculaModalidades.COLUNA_DATA_INICIO,
        MatriculaModalidades.COLUNA_DATA_FIM
    };

    public MatriculaModalidadesDAO(Context context){
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

    public List<MatriculaModalidades> Select(){
        return null;
    }
}
