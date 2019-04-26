package database.dao;

import android.content.ContentValues;
import android.content.Context;

import database.db.DBOpenHelper;

import database.model.Alunos;

import java.util.List;

public class AlunosDAO extends AbstrataDAO {

    private final String [] colunas =
            {
                    Alunos.COLUNA_ID,
                    Alunos.COLUNA_CODIGO_ALUNO,
                    Alunos.COLUNA_NOME,
                    Alunos.COLUNA_DATA_NASCIMENTO,
                    Alunos.COLUNA_SEXO,
                    Alunos.COLUNA_TELEFONE,
                    Alunos.COLUNA_CELULAR,
                    Alunos.COLUNA_EMAIL,
                    Alunos.COLUNA_OBSERVACAO,
                    Alunos.COLUNA_ENDERECO,
                    Alunos.COLUNA_NUMERO,
                    Alunos.COLUNA_COMPLEMENTO,
                    Alunos.COLUNA_BAIRRO,
                    Alunos.COLUNA_CIDADE,
                    Alunos.COLUNA_ESTADO,
                    Alunos.COLUNA_PAIS,
                    Alunos.COLUNA_CEP
            };

    public AlunosDAO (Context ao_context){

        db_helper = new DBOpenHelper(ao_context);

    }

    public void Insert(final Alunos alunos){
        ContentValues values = new ContentValues();
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());
        values.put(Alunos.COLUNA_CODIGO_ALUNO, alunos.getCodigo_aluno());

        open();
        db.insert(Alunos.TABELA_NOME, null, values);
        close();

    }
    public int Delete(){
        return 0;
    }
    public int Update(){
        return 0;
    }
    public List<Alunos> Select(){
        return null;
    }
}
