package com.example.monstrao;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.dao.UsuariosDAO;
import database.model.Alunos;
import database.model.Usuarios;

public class TelaCadastrar extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtSobreNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtSobreNome = findViewById(R.id.edtSobreNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Usuarios users = new Usuarios();
                UsuariosDAO usuariosDAO = new UsuariosDAO(TelaCadastrar.this);

                users.setNome(edtNome.getText().toString());
                users.setSobreNome(edtSobreNome.getText().toString());
                users.setUsuario(edtEmail.getText().toString());
                users.setSenha(edtSenha.getText().toString());
                users.setPerfil("Completo");

                usuariosDAO.Insert(users);
            }
        });
    }
}
