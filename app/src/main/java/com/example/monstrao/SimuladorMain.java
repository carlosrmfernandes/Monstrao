package com.example.monstrao;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SimuladorMain extends AppCompatActivity {

    private Button um, dois, tres, quatro, cinco;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_simulador);

        um = findViewById(R.id.btnCadastrarAlunos);
        um.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SimuladorMain.this, TelaCadastroAluno.class));
            }
        });

        dois = findViewById(R.id.btnCadastrarModalidade);
        dois.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SimuladorMain.this, TelaCadastroModalidades.class));
            }
        });

        tres = findViewById(R.id.btnCadastrarGraduacao);
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SimuladorMain.this, TelaCadastroGraduacoes.class));
            }
        });

        quatro = findViewById(R.id.btnCadastrarPlano);
        quatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SimuladorMain.this, TelaCadastroPlanos.class));
            }
        });

        cinco = findViewById(R.id.btnMatricular);
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SimuladorMain.this, TelaCadastroMatriculas.class));
            }
        });
    }
}
