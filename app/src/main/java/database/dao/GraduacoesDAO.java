package database.dao;

import android.content.Context;

import java.util.List;

import database.db.DBOpenHelper;
import database.model.Graduacoes;

public class GraduacoesDAO extends  AbstrataDAO{

    private final String [] colunas =
            {
                    Graduacoes.COLUNA_CIDADE,
                    Graduacoes.COLUNA_ESTADO,
                    Graduacoes.COLUNA_ID,
                    Graduacoes.COLUNA_PAIS
            };
    public  GraduacoesDAO (Context ao_Context){
        db_helper = new DBOpenHelper(ao_Context);
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
    public List<Graduacoes> Select(){
        return null;
    }

}
