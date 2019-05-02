package database.dao;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import database.db.DBOpenHelper;
import database.model.Graduacoes;

public class GraduacoesDAO extends  AbstrataDAO{

    private final String [] colunas =
            {
                    Graduacoes.GRADUACAO,
                    Graduacoes.MODALIDADE,
                    Graduacoes.COLUNA_ID,
            };
    public  GraduacoesDAO (Context ao_Context){
        db_helper = new DBOpenHelper(ao_Context);
    }

    public void Insert(Graduacoes graduacoes){
        ContentValues value = new ContentValues();
        value.put(Graduacoes.GRADUACAO, graduacoes.getGraduacao());
        value.put(Graduacoes.MODALIDADE, graduacoes.getModalidade());

        open();

        db.insert(Graduacoes.TABELA_NOME, null,value);

        close();
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
