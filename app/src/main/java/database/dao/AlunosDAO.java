package database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import database.db.DBOpenHelper;

import database.model.Alunos;

import java.util.ArrayList;
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
        values.put(Alunos.COLUNA_NOME, alunos.getNome());
        values.put(Alunos.COLUNA_DATA_NASCIMENTO, alunos.getData_nascimento());
        values.put(Alunos.COLUNA_SEXO, alunos.getSexo());
        values.put(Alunos.COLUNA_TELEFONE, alunos.getTelefone());
        values.put(Alunos.COLUNA_CELULAR, alunos.getCelular());
        values.put(Alunos.COLUNA_EMAIL, alunos.getEmail());
        values.put(Alunos.COLUNA_OBSERVACAO, alunos.getObservacao());
        values.put(Alunos.COLUNA_ENDERECO, alunos.getEndereco());
        values.put(Alunos.COLUNA_NUMERO, alunos.getNumero());
        values.put(Alunos.COLUNA_COMPLEMENTO, alunos.getComplemento());
        values.put(Alunos.COLUNA_BAIRRO, alunos.getBairro());
        values.put(Alunos.COLUNA_CIDADE, alunos.getCidade());
        values.put(Alunos.COLUNA_ESTADO, alunos.getEstado());
        values.put(Alunos.COLUNA_PAIS, alunos.getPais());
        values.put(Alunos.COLUNA_CEP, alunos.getCep());

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
        List<Alunos> alunos= new ArrayList<>();
        open();
        Cursor cursor= db.query(Alunos.TABELA_NOME, colunas, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            alunos.add(CursorToStructure(cursor));
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (alunos);
    }

    public boolean SelectAluno(final String id){
        boolean isExist = false;

        open();
        Cursor cursor= db.query(Alunos.TABELA_NOME, colunas, Alunos.COLUNA_ID+" = ? and ", new String[]{id}, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            isExist = true;
            cursor.moveToNext();
        }
        cursor.close();
        close();
        return (isExist);
    }
    public final Alunos CursorToStructure(Cursor cursor){

        Alunos al= new Alunos();
        al.setId(cursor.getString(0));
        al.setCodigo_aluno(cursor.getString(1));
        al.setNome(cursor.getString(2));
        al.setData_nascimento(cursor.getString(3));
        al.setSexo(cursor.getString(4));
        al.setTelefone(cursor.getString(5));
        al.setCelular(cursor.getString(6));
        al.setEmail(cursor.getString(7));
        al.setObservacao(cursor.getString(8));
        al.setEndereco(cursor.getString(9));
        al.setNumero(cursor.getString(10));
        al.setComplemento(cursor.getString(11));
        al.setBairro(cursor.getString(12));
        al.setCidade(cursor.getString(13));
        al.setEstado(cursor.getString(14));
        al.setPais(cursor.getString(15));
        al.setCep(cursor.getString(16));
        return al;
    }
}
