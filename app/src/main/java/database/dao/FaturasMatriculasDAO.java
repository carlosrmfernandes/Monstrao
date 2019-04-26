package database.dao;

import android.content.ContentValues;
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

    public void Insert(FaturasMatriculas faturasMatriculas){

        ContentValues value = new ContentValues();
        value.put(FaturasMatriculas.COLUNA_DATA_CANCELAMENTO, faturasMatriculas.getData_cancelamento());
        value.put(FaturasMatriculas.COLUNA_DATA_PAGAMENTO, faturasMatriculas.getData_pagamento());
        value.put(FaturasMatriculas.COLUNA_DATA_VENCIMENTO, faturasMatriculas.getData_vencimento());
        value.put(FaturasMatriculas.COLUNA_FATURA_MATRICULA, faturasMatriculas.getFaturas_matriculas());
        value.put(FaturasMatriculas.COLUNA_VALOR, faturasMatriculas.getValor());

        open();

        db.insert(FaturasMatriculas.TABELA_NOME, null, value);

        close();

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
