package retrofit;

import java.util.List;

import retrofit.endpoint.AlunosEndpoint;
import retrofit.model.AlunoModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static final String BASE_URL = "http://api.m3.nextcodeapp.com.br/";
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl( BASE_URL)
            .addConverterFactory(GsonConverterFactory. create())
            .build();
    /**
     * Busca o treino semanal.
     */
    public static void GetAlunos(long id_conta, Callback<List<AlunoModel>> callback) {
        AlunosEndpoint endpoint = retrofit.create(AlunosEndpoint. class);
        Call<List<AlunoModel>> call = endpoint.buscarAlunos(id_conta);
        call.enqueue(callback);
    }

    public static void PostAlunos(AlunoModel a, Callback<Boolean> callback) {
        AlunosEndpoint endpoint = retrofit.create(AlunosEndpoint. class);
        Call<Boolean> call = endpoint.inserirAluno(a);
        call.enqueue(callback);
    }
}
