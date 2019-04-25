package database.dao;


import android.content.Context;

import java.util.List;

import database.db.DBOpenHelper;
import database.model.Usuarios;

public class UsuariosDAO extends AbstrataDAO{

    private final String[]
    colunas = {
        Usuarios.COLUNA_ID,
        Usuarios.COLUNA_USARIO,
        Usuarios.COLUNA_PERFIL,
    };

    public UsuariosDAO(Context context){
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

    public List<Usuarios> Select(){
        return null;
    }
}
