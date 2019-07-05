package retrofit.endpoint;

import java.util.List;

import retrofit.model.AlunoModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AlunosEndpoint  {

    @GET ("api/unesc/aluno/buscar")
    Call<List<AlunoModel>> buscarAlunos(@Query("id_conta") long id_conta);

    @POST("api/unesc/aluno/incluir")
    Call<Long> inserirAluno(@Body AlunoModel a);
}
