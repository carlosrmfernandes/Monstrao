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

import com.example.monstrao.util.MonstraoUtil;
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
    private Button btnBuscar;
    private ModalidadesDAO dao;
    private ListView list;
    private GraduacoesDAO daoGraduacoes;
    Spinner s;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_graduacoes);

        dao = new ModalidadesDAO(this);
        daoGraduacoes = new GraduacoesDAO(this);

        s = findViewById(R.id.modalidade);

        edtGraduacao = findViewById(R.id.edt_graduacoes);
        btnConfirmar = findViewById(R.id.cadastro_graduacoes_confirmar);
        btnLimpar = findViewById(R.id.cadastro_graduacoes_limpar);
        modalidade = findViewById(R.id.modalidade);
        btnBuscar = findViewById(R.id.buscar_graduação);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lit();
            }
        });
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
                g.setId_modalidade(Long.valueOf(s.getSelectedItem().toString().split("-")[0]));
                g.setIdConta(21);
                final SweetAlertDialog pDialog = new SweetAlertDialog(TelaCadastroGraduacoes. this, SweetAlertDialog. PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color. parseColor("#f4971c"));
                pDialog.setTitleText( "Enviando. Aguarde ...");
                pDialog.setCancelable( false);
                pDialog.show();

                Api.PostGraduacoes(g, new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
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
                    public void onFailure(Call<Long> call, Throwable t) {

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

        if (MonstraoUtil.isNetworkAvailable(this)) {
            Api.GetModalidade(21, new Callback<List<ModalidadeModel>>() {
                @Override
                public void onResponse(Call<List<ModalidadeModel>> call, Response<List<ModalidadeModel>> response) {
                    if (response != null && response.body() != null && response.body().size() > 0) {
                        List<ModalidadeModel> mod = response.body();
                        String[] modalidades = new String[mod.size()];
                        for (int i = 0; i < mod.size(); i++) {
                            modalidades[i] = mod.get(i).getId() + "-" + mod.get(i).getNm_modalidade();
                        }
                        if (modalidades.length > 0) {
                            s.setAdapter(new ArrayAdapter<String>(TelaCadastroGraduacoes.this,  android.R.layout.simple_list_item_1, modalidades));
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<ModalidadeModel>> call, Throwable t) {

                }
            });
        }
        else {
            List<Modalidades> mod = dao.Select();
            String[] modalidades = new String[mod.size()];
            for (int i = 0; i < mod.size(); i++) {
                modalidades[i] = mod.get(i).getModalidade();
            }
            if (modalidades.length > 0) {
                s.setAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, modalidades));
            }
        }

    }
    void lit(){
        if (MonstraoUtil.isNetworkAvailable(this)) {
            Api.GetGraduacoes(21, Long.valueOf(s.getSelectedItem().toString().split("-")[0]), new Callback<List<GraduacoesModel>>() {
                @Override
                public void onResponse(Call<List<GraduacoesModel>> call, Response<List<GraduacoesModel>> response) {
                    if (response != null && response.body() != null && response.body().size() > 0) {
                        List<GraduacoesModel> mod = response.body();
                        String[] graduacoes = new String[mod.size()];
                        for (int i = 0; i < mod.size(); i++) {
                            graduacoes[i] = mod.get(i).getDs_graduacao();
                        }
                        if (graduacoes.length > 0) {
                            list.setAdapter(new ArrayAdapter<String>(TelaCadastroGraduacoes.this,  android.R.layout.simple_list_item_1, graduacoes));
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<GraduacoesModel>> call, Throwable t) {

                }
            });
        }
        else {
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
}
