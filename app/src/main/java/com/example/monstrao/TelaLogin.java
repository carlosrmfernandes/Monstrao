package com.example.monstrao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import database.dao.UsuariosDAO;
import database.model.Usuarios;


public class TelaLogin extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnCriarConta;
    private Button btnContinuar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        edtEmail = findViewById(R.id.txtEmail);
        edtSenha = findViewById(R.id.txtSenha);
        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UsuariosDAO usuariosDAO = new UsuariosDAO(TelaLogin.this);
                if (usuariosDAO.SelectUsuario(edtEmail.getText().toString(), edtSenha.getText().toString()))
                {
                    Toast.makeText(TelaLogin.this, "EXISTE O USUARIO", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(TelaLogin.this, "USUÁRIO INEXISTENTE", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnCriarConta = findViewById(R.id.btnCriarConta);
        btnCriarConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaLogin.this, TelaCadastrar.class));
            }
        });

    }
}
