package database.dao;

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

    public int Insert(){
        return 0;
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
