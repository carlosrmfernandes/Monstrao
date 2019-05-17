package com.example.monstrao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import database.dao.GraduacoesDAO;
import database.dao.ModalidadesDAO;
import database.model.Graduacoes;
import database.model.Modalidades;

public class TelaCadastroGraduacoes extends AppCompatActivity {

    private EditText edtGraduacao;
    private Spinner modalidade;
    private Button btnConfirmar;
    private Button btnLimpar;
    private ModalidadesDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_graduacoes);

        dao = new ModalidadesDAO(this);

        edtGraduacao = findViewById(R.id.edt_graduacoes);
        btnConfirmar = findViewById(R.id.cadastro_graduacoes_confirmar);
        btnLimpar = findViewById(R.id.cadastro_graduacoes_limpar);
        modalidade = findViewById(R.id.modalidade);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Graduacoes grad = new Graduacoes();
                GraduacoesDAO gradDao = new GraduacoesDAO(TelaCadastroGraduacoes.this);

                grad.setGraduacao(edtGraduacao.getText().toString());
                grad.setModalidade(String.valueOf(modalidade.getSelectedItemId()+1));
                gradDao.Insert(grad);
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edtGraduacao.setText("");


            }
        });

        List<Modalidades> mod = dao.Select();
        String[] modalidades = new String[mod.size()];
        for (int i = 0; i < mod.size(); i++) {
            modalidades[i] = mod.get(i).getModalidade();
        }

        Spinner s = findViewById(R.id.modalidade);

        if (modalidades.length > 0) {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, modalidades);
            s.setAdapter(adapter);
        }
        else {

        }

    }
}
