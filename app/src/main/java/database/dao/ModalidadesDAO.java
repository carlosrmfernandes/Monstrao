package database.dao;


import android.content.Context;

import java.util.List;

import database.db.DBOpenHelper;
import database.model.Modalidades;

public class ModalidadesDAO extends AbstrataDAO{

    private final String[]
    colunas = {
        Modalidades.COLUNA_ID,
        Modalidades.COLUNA_MODALIDAE
    };

    public ModalidadesDAO(Context context){
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

    public List<Modalidades> Select(){
        return null;
    }
}
