package retrofit.endpoint;

import java.util.List;

import retrofit.model.GraduacoesModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GraduacoesEndpoint {

    @GET ("api/unesc/graduacao/buscar")
    Call<List<GraduacoesModel>> buscarGraduacoes(@Query("id_conta") long id_conta);

    @POST("api/unesc/graduacao/incluir")
    Call<Boolean> inserirGraduacoes(@Body GraduacoesModel g);
}
