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

import database.model.Graduacoes;
import database.model.Modalidades;
import database.model.Planos;
import database.dao.PlanosDAO;
import database.dao.ModalidadesDAO;
import retrofit.Api;
import retrofit.model.GraduacoesModel;
import retrofit.model.ModalidadeModel;
import retrofit.model.PlanosModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TelaCadastroPlanos extends AppCompatActivity {

    private Spinner modalidade;
    private EditText edtPlano;
    private EditText edtValor;
    private Button btnConfirmar;
    private Button btnLimpar;
    private ModalidadesDAO dao;
    private PlanosDAO daoPlanos;
    private Button btnBuscar;
    private ListView list;
    private Spinner s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_planos);
        dao = new ModalidadesDAO(this);
        daoPlanos = new PlanosDAO(this);
        s = findViewById(R.id.modalidade);
        edtPlano = findViewById(R.id.edt_planos);
        edtValor = findViewById(R.id.edt_valor);
        btnConfirmar = findViewById(R.id.cadastro_planos_confirmar);
        btnLimpar = findViewById(R.id.cadastro_planos_limpar);
        modalidade = findViewById(R.id.modalidade);
        btnBuscar = findViewById(R.id.buscar_planos);
        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lit();
            }
        });
        list = findViewById(R.id.list_planos);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Planos plano= new Planos();
                PlanosDAO planodao = new PlanosDAO(TelaCadastroPlanos.this);
                plano.setPlano(edtPlano.getText().toString());
                plano.setValor_mensal(Double.parseDouble(edtValor.getText().toString()));
                plano.setModalidade(String.valueOf(modalidade.getSelectedItemId()+1));
                //planodao.Insert(plano);
                PlanosModel p = new PlanosModel();
                p.setDs_plano(edtPlano.getText().toString());
                p.setId_modalidade(Long.valueOf(s.getSelectedItem().toString().split("-")[0]));
                p.setValor(Double.parseDouble(edtValor.getText().toString()));
                p.setIdConta(21);
                final SweetAlertDialog pDialog = new SweetAlertDialog(TelaCadastroPlanos. this, SweetAlertDialog. PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color. parseColor("#f4971c"));
                pDialog.setTitleText( "Enviando. Aguarde ...");
                pDialog.setCancelable( false);
                pDialog.show();

                Api.PostPlanos(p, new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {

                        pDialog.dismissWithAnimation();

                        if(response != null && response.body() != null){


                            System.out.println("***************** Inserido com sucesso  ");
                            // Lançar erros
                            new SweetAlertDialog(TelaCadastroPlanos. this, SweetAlertDialog. SUCCESS_TYPE)
                                    .setTitleText( "Sucesso")
                                    .setContentText( "Plano inserido !")
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
                            s.setAdapter(new ArrayAdapter<String>(TelaCadastroPlanos.this,  android.R.layout.simple_list_item_1, modalidades));
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

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPlano.setText("");
                edtValor.setText("");
            }
        });
    }
    void lit(){
        if (MonstraoUtil.isNetworkAvailable(this)) {
            Api.GetPlanos(21, Long.valueOf(s.getSelectedItem().toString().split("-")[0]), new Callback<List<PlanosModel>>() {
                @Override
                public void onResponse(Call<List<PlanosModel>> call, Response<List<PlanosModel>> response) {
                    if (response != null && response.body() != null && response.body().size() > 0) {
                        List<PlanosModel> mod = response.body();
                        String[] plano = new String[mod.size()];
                        for (int i = 0; i < mod.size(); i++) {
                            plano[i] = mod.get(i).getDs_plano();
                        }
                        if (plano.length > 0) {
                            list.setAdapter(new ArrayAdapter<String>(TelaCadastroPlanos.this,  android.R.layout.simple_list_item_1, plano));
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<PlanosModel>> call, Throwable t) {

                }
            });
        }
        else {
            List<Planos> mod = daoPlanos.Select();
            String[] plano = new String[mod.size()];
            for (int i = 0; i < mod.size(); i++) {
                plano[i] = mod.get(i).getPlano();
            }
            if (plano.length > 0) {
                list.setAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, plano));
            }
        }
    }
}
