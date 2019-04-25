package database.dao;

import android.content.Context;

import java.util.List;

import database.db.DBOpenHelper;
import database.model.FaturasMatriculas;

public class FaturasMatriculasDAO extends  AbstrataDAO {

    private final String [] colunas =
            {
                    FaturasMatriculas.COLUNA_DATA_CANCELAMENTO,
                    FaturasMatriculas.COLUNA_DATA_PAGAMENTO,
                    FaturasMatriculas.COLUNA_DATA_VENCIMENTO,
                    FaturasMatriculas.COLUNA_FATURA_MATRICULA,
                    FaturasMatriculas.COLUNA_ID,
                    FaturasMatriculas.COLUNA_VALOR
            };

    public FaturasMatriculasDAO (Context ao_Context){
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
    public  List<FaturasMatriculas> Select(){
        return null;
    }
}
