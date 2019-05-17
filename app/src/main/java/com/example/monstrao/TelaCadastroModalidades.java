package com.example.monstrao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import database.dao.ModalidadesDAO;
import database.model.Modalidades;

public class TelaCadastroModalidades extends AppCompatActivity {

    private EditText edtModalidade;
    private Button btnConfirmar;
    private Button btnLimpar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_modalidade);

        edtModalidade = findViewById(R.id.edt_modalidade);

        btnConfirmar = findViewById(R.id.cadastro_modalidade_confirmar);
        btnLimpar = findViewById(R.id.cadastro_modalidade_limpar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Modalidades mod = new Modalidades();
                ModalidadesDAO modDao = new ModalidadesDAO(TelaCadastroModalidades.this);

                mod.setModalidade(edtModalidade.getText().toString());
                modDao.insert(mod);

            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtModalidade.setText("");


            }
        });

    }
}
