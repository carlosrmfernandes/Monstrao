package database.dao;

import android.content.ContentValues;
import android.content.Context;

import database.db.DBOpenHelper;
import database.model.Assiduidade;

import java.util.List;

public class AssiduidadeDAO extends  AbstrataDAO {

    private final String [] colunas =
            {
                    Assiduidade.COLUNA_CODIGO_MaTRICULA,
                    Assiduidade.COLUNA_DATA_ENTRADA,
                    Assiduidade.COLUNA_ID
            };

    public AssiduidadeDAO (Context ao_Context){
        db_helper = new DBOpenHelper(ao_Context);
    }

    public void Insert(Assiduidade assiduidade){
        ContentValues values = new ContentValues();
        values.put(Assiduidade.COLUNA_CODIGO_MaTRICULA, assiduidade.getCodigo_matricula());
        values.put(Assiduidade.COLUNA_DATA_ENTRADA, assiduidade.getData_entrada());

        open();
        db.insert(Assiduidade.TABELA_NOME, null, values);
        close();
    }
    public int Delete(){
        return 0;
    }
    public int Update(){
        return 0;
    }
    public List<Assiduidade> Select(){
        return null;
    }
}
