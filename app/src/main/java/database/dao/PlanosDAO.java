package database.dao;


import android.content.ContentValues;
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

    public void Insert(Planos planos){

        ContentValues value = new ContentValues();
        value.put(Planos.COLUNA_MODALIDAE, planos.getModalidade());
        value.put(Planos.COLUNA_PLANO, planos.getPlano());
        value.put(Planos.COLUNA_VALORMENSAL, planos.getValor_mensal());

        open();

        db.insert(Planos.TABELA_NOME, null,value);

        close();
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
