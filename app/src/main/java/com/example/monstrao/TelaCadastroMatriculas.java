package com.example.monstrao;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import database.dao.AlunosDAO;
import database.dao.MatriculasDAO;
import database.model.Alunos;
import database.model.Matriculas;
import database.model.Modalidades;


public class TelaCadastroMatriculas extends AppCompatActivity {

    private EditText edt_matricula;
    private EditText cod_matricula;
    private Button btn_confirmar;
    private Button btn_limpar;
    private AlunosDAO dao;
    private Spinner alunos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_matriculas);

        dao = new AlunosDAO(this);

        edt_matricula = findViewById(R.id.edt_data_matricula);
        btn_confirmar = findViewById(R.id.btn_confirmar);
        btn_limpar = findViewById(R.id.bnt_limpar_matriculas);
        alunos = findViewById(R.id.alunos);
        cod_matricula = findViewById(R.id.codigo_matricula);

        btn_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Matriculas matricula = new Matriculas();
                MatriculasDAO matriculasDAO = new MatriculasDAO(TelaCadastroMatriculas.this);
                matricula.setData_matricula(edt_matricula.getText().toString());
                matricula.setCodigo_matricula(Integer.valueOf(edt_matricula.getText().toString()));
                matricula.setCodigo_aluno((int)alunos.getSelectedItemId());
                matriculasDAO.Insert(matricula);
            }
        });



        List<Alunos> mod = dao.Select();
        String[] alunos = new String[mod.size()];
        for (int i = 0; i < mod.size(); i++) {
            alunos[i] = mod.get(i).getNome();
        }

        Spinner s = findViewById(R.id.alunos);

        if (alunos.length > 0) {
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, alunos);
            s.setAdapter(adapter);
        }
    }
}
