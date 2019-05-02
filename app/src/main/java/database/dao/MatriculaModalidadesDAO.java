package database.dao;


import android.content.ContentValues;
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
            MatriculaModalidades.COLUNA_GRADUACAO,
        MatriculaModalidades.COLUNA_DATA_FIM
    };

    public MatriculaModalidadesDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void Insert(MatriculaModalidades matriculaModalidades){
        ContentValues values = new ContentValues();
        values.put(MatriculaModalidades.COLUNA_CODIGO_MATRICULA, matriculaModalidades.getCodigo_matricula());
        values.put(MatriculaModalidades.COLUNA_MODALIDADE, matriculaModalidades.getModalidade());
        values.put(MatriculaModalidades.COLUNA_PLANO, matriculaModalidades.getPlano());
        values.put(MatriculaModalidades.COLUNA_DATA_INICIO, matriculaModalidades.getData_inicio());
        values.put(MatriculaModalidades.COLUNA_DATA_FIM, matriculaModalidades.getData_fim());
        values.put(MatriculaModalidades.COLUNA_GRADUACAO, matriculaModalidades.getGraduacao());

        open();
        db.insert(MatriculaModalidades.TABELA_NOME, null, values);
        close();
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
