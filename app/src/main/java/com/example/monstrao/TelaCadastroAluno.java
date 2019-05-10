package com.example.monstrao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.dao.AlunosDAO;
import database.model.Alunos;

public class TelaCadastroAluno extends AppCompatActivity {

    private EditText edtNome, edtDataNascimento, edtSexo, edtTelefone, edtCelular, edtEmail, edtObservacao,
            edtEndereco, edtNumero, edtComplemento, edtBairro, edtCidade, edtEstado, edtPais, edtCep;

    private Button btnConfirmar, btnLimpar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_aluno);

        edtNome = findViewById(R.id.edt_nome);
        edtDataNascimento = findViewById(R.id.edt_data_nascimento);
        edtSexo = findViewById(R.id.edt_sexo);
        edtTelefone = findViewById(R.id.edt_telefone);
        edtCelular = findViewById(R.id.edt_celular);
        edtEmail = findViewById(R.id.edt_email);
        edtObservacao = findViewById(R.id.edt_observacao);
        edtEndereco = findViewById(R.id.edt_endereco);
        edtNumero = findViewById(R.id.edt_numero);
        edtComplemento = findViewById(R.id.edt_complemento);
        edtBairro = findViewById(R.id.edt_bairro);
        edtCidade = findViewById(R.id.edt_cidade);
        edtEstado = findViewById(R.id.edt_estado);
        edtPais = findViewById(R.id.edt_pais);
        edtCep = findViewById(R.id.edt_cep);
        btnConfirmar = findViewById(R.id.btn_cadastro_aluno_confirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Alunos al = new Alunos ();
                AlunosDAO alunoDAO = new AlunosDAO (TelaCadastroAluno.this);

                al.setNome(edtNome.getText().toString());
                al.setData_nascimento(edtDataNascimento.getText().toString());
                al.setSexo(edtSexo.getText().toString());
                al.setTelefone(edtTelefone.getText().toString());
                al.setCelular(edtCelular.getText().toString());
                al.setEmail(edtEmail.getText().toString());
                al.setObservacao(edtObservacao.getText().toString());
                al.setEndereco(edtEndereco.getText().toString());
                al.setNumero(edtNumero.getText().toString());
                al.setComplemento(edtComplemento.getText().toString());
                al.setBairro(edtBairro.getText().toString());
                al.setCidade(edtCidade.getText().toString());
                al.setEstado(edtEstado.getText().toString());
                al.setPais(edtPais.getText().toString());
                al.setCep(edtCep.getText().toString());
                al.setCodigo_aluno("123");
                alunoDAO.Insert(al);
            }
        });
    }
}
