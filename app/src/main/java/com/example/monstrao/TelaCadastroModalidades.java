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

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import java.util.List;

import database.dao.ModalidadesDAO;
import database.model.Modalidades;
import retrofit.Api;
import retrofit.model.ModalidadeModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TelaCadastroModalidades extends AppCompatActivity {

    private EditText edtModalidade;
    private Button btnConfirmar;
    private ListView list;
    private Button btnLimpar;
    private ModalidadesDAO dao;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_modalidade);
        dao = new ModalidadesDAO(this);
        edtModalidade = findViewById(R.id.edt_modalidade);

        list = findViewById(R.id.list_modalidades);

        btnConfirmar = findViewById(R.id.cadastro_modalidade_confirmar);
        btnLimpar = findViewById(R.id.cadastro_modalidade_limpar);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Modalidades mod = new Modalidades();
                ModalidadesDAO modDao = new ModalidadesDAO(TelaCadastroModalidades.this);

                mod.setModalidade(edtModalidade.getText().toString());
                //modDao.insert(mod);

                ModalidadeModel m = new ModalidadeModel();
                m.setNm_modalidade(edtModalidade.getText().toString());
                m.setIdConta(21);
                final SweetAlertDialog pDialog = new SweetAlertDialog(TelaCadastroModalidades. this, SweetAlertDialog. PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color. parseColor("#f4971c"));
                pDialog.setTitleText( "Enviando. Aguarde ...");
                pDialog.setCancelable( false);
                pDialog.show();


                Api.PostModalidade(m, new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        pDialog.dismissWithAnimation();

                        if(response != null && response.body() != null){


                            System.out.println("***************** Inserido com sucesso  ");
                            // Lançar erros
                            new SweetAlertDialog(TelaCadastroModalidades. this, SweetAlertDialog. SUCCESS_TYPE)
                                    .setTitleText( "Sucesso")
                                    .setContentText( "Modalidade inserido !")
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
                edtModalidade.setText("");
            }
        });
        lit();
    }

    void lit(){
        List<Modalidades> mod = dao.Select();
        String[] modalidades = new String[mod.size()];
        for (int i = 0; i < mod.size(); i++) {
            modalidades[i] = mod.get(i).getModalidade();
        }
        if (modalidades.length > 0) {
            list.setAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, modalidades));
        }
    }
}
