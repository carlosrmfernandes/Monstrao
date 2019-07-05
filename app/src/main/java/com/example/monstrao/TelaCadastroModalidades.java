package com.example.monstrao;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.monstrao.util.MonstraoUtil;
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
    private EditText edtdelete;
    private Button btnConfirmar;
    private ListView list;
    private Button btnLimpar;
    private Button btnDelete;
    private ModalidadesDAO dao;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_modalidade);
        dao = new ModalidadesDAO(this);
        edtModalidade = findViewById(R.id.edt_modalidade);
        edtdelete = findViewById(R.id.id_delete);
        btnDelete = findViewById(R.id.delete_mod);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Api.deleteModalidade(Long.valueOf(edtdelete.getText().toString()) , new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        if(response != null && response.body() != null){


                            System.out.println("***************** Excluido com sucesso  ");
                            // Lançar erros
                            new SweetAlertDialog(TelaCadastroModalidades. this, SweetAlertDialog. SUCCESS_TYPE)
                                    .setTitleText( "Sucesso")
                                    .setContentText( "Modalidade Excluida !")
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
                        t.printStackTrace();
                    }
                });
            }
        });
        list = findViewById(R.id.list_modalidades);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Api.deleteModalidade(Long.valueOf(list.getSelectedItem().toString().split("-")[0]) , new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        if(response != null && response.body() != null){


                            System.out.println("***************** Excluido com sucesso  ");
                            // Lançar erros
                            new SweetAlertDialog(TelaCadastroModalidades. this, SweetAlertDialog. SUCCESS_TYPE)
                                    .setTitleText( "Sucesso")
                                    .setContentText( "Modalidade Excluida !")
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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


                Api.PostModalidade(m, new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {

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
                    public void onFailure(Call<Long> call, Throwable t) {

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

        if (MonstraoUtil.isNetworkAvailable(this)) {
            Api.GetModalidade(21, new Callback<List<ModalidadeModel>>() {
                @Override
                public void onResponse(Call<List<ModalidadeModel>> call, Response<List<ModalidadeModel>> response) {
                    if (response != null && response.body() != null && response.body().size() > 0) {
                        List<ModalidadeModel> mod = response.body();
                        String[] modalidades = new String[mod.size()];
                        for (int i = 0; i < mod.size(); i++) {
                            modalidades[i] =mod.get(i).getId() + "-" + mod.get(i).getNm_modalidade();
                        }
                        if (modalidades.length > 0) {
                            list.setAdapter(new ArrayAdapter<String>(TelaCadastroModalidades.this,  android.R.layout.simple_list_item_1, modalidades));
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
                list.setAdapter(new ArrayAdapter<String>(this,  android.R.layout.simple_list_item_1, modalidades));
            }
        }

    }
}
