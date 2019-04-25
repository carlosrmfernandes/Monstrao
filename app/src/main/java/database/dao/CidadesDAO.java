package database.dao;

import android.content.Context;

import database.db.DBOpenHelper;
import database.model.Cidades;

import java.util.List;

public class CidadesDAO extends  AbstrataDAO{

    private final String [] colunas =
            {
                    Cidades.COLUNA_CIDADE,
                    Cidades.COLUNA_ESTADO,
                    Cidades.COLUNA_ID,
                    Cidades.COLUNA_PAIS
            };

    public CidadesDAO (Context ao_Context){
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
    public  List<Cidades> Select(){
        return null;
    }

}
