package com.example.monstrao;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import java.util.List;

import database.dao.GraduacoesDAO;
import database.dao.ModalidadesDAO;
import database.model.Graduacoes;
import database.model.Modalidades;
import retrofit.Api;
import retrofit.model.GraduacoesModel;
import retrofit.model.ModalidadeModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaCadastroGraduacoes extends AppCompatActivity {

    private EditText edtGraduacao;
    private Spinner modalidade;
    private Button btnConfirmar;
    private Button btnLimpar;
    private ModalidadesDAO dao;
    private ListView list;
    private GraduacoesDAO daoGraduacoes;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_graduacoes);

        dao = new ModalidadesDAO(this);
        daoGraduacoes = new GraduacoesDAO(this);

        edtGraduacao = findViewById(R.id.edt_graduacoes);
        btnConfirmar = findViewById(R.id.cadastro_graduacoes_confirmar);
        btnLimpar = findViewById(R.id.cadastro_graduacoes_limpar);
        modalidade = findViewById(R.id.modalidade);
        list = findViewById(R.id.list_graduacoes);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Graduacoes grad = new Graduacoes();
                GraduacoesDAO gradDao = new GraduacoesDAO(TelaCadastroGraduacoes.this);

                grad.setGraduacao(edtGraduacao.getText().toString());
                grad.setModalidade(String.valueOf(modalidade.getSelectedItemId()+1));
               // gradDao.Insert(grad);

                GraduacoesModel g = new GraduacoesModel();
                g.setDs_graduacao(edtGraduacao.getText().toString());
                g.setId_modalidade(2);
                g.setIdConta(21);
                final SweetAlertDialog pDialog = new SweetAlertDialog(TelaCadastroGraduacoes. this, SweetAlertDialog. PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color. parseColor("#f4971c"));
                pDialog.setTitleText( "Enviando. Aguarde ...");
                pDialog.setCancelable( false);
                pDialog.show();


                Api.PostGraduacoes(g, new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        pDialog.dismissWithAnimation();

                        if(response != null && response.body() != null){


                            System.out.println("***************** Inserido com sucesso  ");
                            // Lançar erros
                            new SweetAlertDialog(TelaCadastroGraduacoes. this, SweetAlertDialog. SUCCESS_TYPE)
                                    .setTitleText( "Sucesso")
                                    .setContentText( "Graduação inserido !")
                                    .setConfirmClickListener( new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                                            sweetAlertDialog.dismissWithAnimation();
                                        }
                                    })
                                    .show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });
                lit();
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
        lit();

    }
    void lit(){
        List<Graduacoes> mod = daoGraduacoes.Select();
        String[] graduacoes = new String[mod.size()];
        for (int i = 0; i < mod.size(); i++) {
            graduacoes[i] = mod.get(i).getGraduacao();
        }
        if (graduacoes.length > 0) {
            list.setAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, graduacoes));
        }
    }
}
