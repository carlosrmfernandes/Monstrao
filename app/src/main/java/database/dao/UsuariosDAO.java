package database.dao;


import android.content.ContentValues;
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
        Usuarios.COLUNA_NOME,
        Usuarios.COLUNA_SOBRENOME,
        Usuarios.COLUNA_SENHA
    };

    public UsuariosDAO(Context context){
        db_helper = new DBOpenHelper(context);
    }

    public void Insert(Usuarios usuarios){

        ContentValues value = new ContentValues();
        value.put(Usuarios.COLUNA_USARIO, usuarios.getUsuario());
        value.put(Usuarios.COLUNA_PERFIL, usuarios.getPerfil());
        value.put(Usuarios.COLUNA_NOME, usuarios.getNome());
        value.put(Usuarios.COLUNA_SOBRENOME, usuarios.getSobreNome());
        value.put(Usuarios.COLUNA_SENHA, usuarios.getSenha());

        open();

        db.insert(Usuarios.TABELA_NOME, null,value);

        close();
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
