package com.example.monstrao;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import java.util.List;

import database.dao.AlunosDAO;
import database.model.Alunos;
import retrofit.Api;
import retrofit.model.AlunoModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TelaCadastroAluno extends AppCompatActivity {

    private EditText edtNome, edtDataNascimento, edtSexo, edtTelefone, edtCelular, edtEmail, edtObservacao,
            edtEndereco, edtNumero, edtComplemento, edtBairro, edtCidade, edtEstado, edtPais, edtCep;

    private Button btnConfirmar, btnLimpar, btn_buscar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_cadastro_aluno);

        edtNome = findViewById(R.id.edt_nome);
        edtDataNascimento = findViewById(R.id.edt_data_nascimento);
        edtSexo = findViewById(R.id.edt_sexo);
        edtTelefone = findViewById(R.id.edt_telefone);
        edtCelular = findViewById(R.id.edt_celular);
        edtEmail = findViewById(R.id.edt_email);
        edtObservacao = findViewById(R.id.edt_observacao);
        edtEndereco = findViewById(R.id.edt_endereco);
        edtNumero = findViewById(R.id.edt_numero);
        edtComplemento = findViewById(R.id.edt_complemento);
        edtBairro = findViewById(R.id.edt_bairro);
        edtCidade = findViewById(R.id.edt_cidade);
        edtEstado = findViewById(R.id.edt_estado);
        edtPais = findViewById(R.id.edt_pais);
        edtCep = findViewById(R.id.edt_cep);
        btnConfirmar = findViewById(R.id.btn_cadastro_aluno_confirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Alunos al = new Alunos ();
                AlunosDAO alunoDAO = new AlunosDAO (TelaCadastroAluno.this);

                al.setNome(edtNome.getText().toString());
                al.setData_nascimento(edtDataNascimento.getText().toString());
                al.setSexo(edtSexo.getText().toString());
                al.setTelefone(edtTelefone.getText().toString());
                al.setCelular(edtCelular.getText().toString());
                al.setEmail(edtEmail.getText().toString());
                al.setObservacao(edtObservacao.getText().toString());
                al.setEndereco(edtEndereco.getText().toString());
                al.setNumero(edtNumero.getText().toString());
                al.setComplemento(edtComplemento.getText().toString());
                al.setBairro(edtBairro.getText().toString());
                al.setCidade(edtCidade.getText().toString());
                al.setEstado(edtEstado.getText().toString());
                al.setPais(edtPais.getText().toString());
                al.setCep(edtCep.getText().toString());
                al.setCodigo_aluno("123");
              //  alunoDAO.Insert(al);

                AlunoModel a = new AlunoModel();
                a.setNm_aluno(edtNome.getText().toString());
                a.setData_nascimento(edtDataNascimento.getText().toString());
                a.setSexo(edtSexo.getText().toString());
                a.setTelefone(edtTelefone.getText().toString());
                a.setCelular(edtCelular.getText().toString());
                a.setEmail(edtEmail.getText().toString());
                a.setObservacao(edtObservacao.getText().toString());
                a.setEndereco(edtEndereco.getText().toString());
                a.setNumero(edtNumero.getText().toString());
                a.setComplemento(edtComplemento.getText().toString());
                a.setBairro(edtBairro.getText().toString());
                a.setCidade(edtCidade.getText().toString());
                a.setEstado(edtEstado.getText().toString());
                a.setPais(edtPais.getText().toString());
                a.setCep(edtCep.getText().toString());
                a.setIdConta(21);

                // Janela Progress com animação
                final SweetAlertDialog pDialog = new SweetAlertDialog(TelaCadastroAluno. this, SweetAlertDialog. PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color. parseColor("#f4971c"));
                pDialog.setTitleText( "Enviando. Aguarde ...");
                pDialog.setCancelable( false);
                pDialog.show();


                Api.PostAlunos(a, new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {

                        pDialog.dismissWithAnimation();

                        if(response != null && response.body() != null){


                                System.out.println("***************** Inserido com sucesso  ");
                            // Lançar erros
                            new SweetAlertDialog(TelaCadastroAluno. this, SweetAlertDialog. SUCCESS_TYPE)
                                .setTitleText( "Sucesso")
                                .setContentText( "Aluno inserido !")
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
                    t.printStackTrace();
                    }
                });

            }
        });

        btn_buscar = findViewById(R.id.btn_buscar);
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Janela Progress com animação
                final SweetAlertDialog pDialog = new SweetAlertDialog(TelaCadastroAluno. this, SweetAlertDialog. PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color. parseColor("#f4971c"));
                pDialog.setTitleText( "Buscando. Aguarde ...");
                pDialog.setCancelable( false);
                pDialog.show();

                Api.GetAlunos(21, new Callback<List<AlunoModel>>() {
                    @Override
                    public void onResponse(Call<List<AlunoModel>> call, Response<List<AlunoModel>> response) {

                        pDialog.dismissWithAnimation();

                        if(response != null && response.body() != null && response.body().size() > 0){

                            for(AlunoModel a : response.body()){
                                Toast.makeText(TelaCadastroAluno.this, a.getNm_aluno(), Toast.LENGTH_LONG).show();
                                System.out.println("***************** "+a.getNm_aluno());
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<List<AlunoModel>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }
}
