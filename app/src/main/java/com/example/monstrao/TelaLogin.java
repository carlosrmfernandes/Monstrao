package com.example.monstrao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
        btnCriarConta = findViewById(R.id.btnCriarConta);

        final Boolean possuiC = false;

        btnCriarConta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(possuiC){
                    edtSenha.setVisibility(View.VISIBLE);
                }else{
                    startActivity(new Intent(TelaLogin.this, TelaCadastrar.class));
                }
            }
        });

    }
}
