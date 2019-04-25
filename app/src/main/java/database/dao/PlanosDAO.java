package database.dao;


import android.content.Context;

import java.util.List;

import database.db.DBOpenHelper;
import database.model.Modalidades;
import database.model.Planos;

public class PlanosDAO extends AbstrataDAO{

    private final String[]
    colunas = {
        Planos.COLUNA_ID,
        Planos.COLUNA_MODALIDAE,
        Planos.COLUNA_PLANO,
        Planos.COLUNA_VALORMENSAL
    };

    public PlanosDAO(Context context){
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

    public List<Planos> Select(){
        return null;
    }
}
