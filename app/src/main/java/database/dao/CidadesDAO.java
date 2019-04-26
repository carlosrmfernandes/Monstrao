package database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

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

    public void Insert(Cidades cidades){
        ContentValues value = new ContentValues();
        value.put(Cidades.COLUNA_CIDADE, cidades.getCidade());
        value.put(Cidades.COLUNA_ESTADO, cidades.getEstado());
        value.put(Cidades.COLUNA_PAIS, cidades.getPais());

        open();

        db.insert(Cidades.TABELA_NOME, null,value);

        close();
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
