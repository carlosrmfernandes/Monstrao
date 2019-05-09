package database.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
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
    List<Usuarios> usuarios = new ArrayList<>();
    open();
        Cursor cursor= db.query(Usuarios.TABELA_NOME, colunas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            usuarios.add(CursorToStructure(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (usuarios);
    }

    public boolean SelectUsuario(final String usuario, final String senha){
        boolean isExist = false;

        open();
        Cursor cursor= db.query(Usuarios.TABELA_NOME, colunas, Usuarios.COLUNA_USARIO+" = ? and "+Usuarios.COLUNA_SENHA+" = ?", new String[]{usuario, senha}, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            isExist = true;
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (isExist);
    }

    public final Usuarios  CursorToStructure(Cursor cursor){

        Usuarios us= new Usuarios();
        us.setId(cursor.getString(0));
        us.setUsuario(cursor.getString(1));
        us.setPerfil(cursor.getString(2));
        us.setSobreNome(cursor.getString(3));
        us.setUsuario(cursor.getString(4));
        return us;
    }
}


