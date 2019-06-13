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

import database.model.Modalidades;
import database.model.Planos;
import database.dao.PlanosDAO;
import database.dao.ModalidadesDAO;
import retrofit.Api;
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
    private ListView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_planos);
        dao = new ModalidadesDAO(this);
        daoPlanos = new PlanosDAO(this);

        edtPlano = findViewById(R.id.edt_planos);
        edtValor = findViewById(R.id.edt_valor);
        btnConfirmar = findViewById(R.id.cadastro_planos_confirmar);
        btnLimpar = findViewById(R.id.cadastro_planos_limpar);
        modalidade = findViewById(R.id.modalidade);
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
                p.setId_modalidade(2);
                p.setValor(Double.parseDouble(edtValor.getText().toString()));
                p.setIdConta(21);
                final SweetAlertDialog pDialog = new SweetAlertDialog(TelaCadastroPlanos. this, SweetAlertDialog. PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color. parseColor("#f4971c"));
                pDialog.setTitleText( "Enviando. Aguarde ...");
                pDialog.setCancelable( false);
                pDialog.show();


                Api.PostPlanos(p, new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

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
                    public void onFailure(Call<Boolean> call, Throwable t) {

                    }
                });

                lit();
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
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtPlano.setText("");
                edtValor.setText("");
            }
        });
        lit();

    }
    void lit(){
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
