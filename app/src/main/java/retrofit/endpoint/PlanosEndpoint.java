package retrofit.endpoint;


import java.util.List;

import retrofit.model.GraduacoesModel;
import retrofit.model.PlanosModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlanosEndpoint {

    @GET ("api/unesc/planos/buscar")
    Call<List<PlanosModel>> buscarPlanos(@Query("id_conta") long id_conta);

    @POST("api/unesc/planos/incluir")
    Call<Boolean> inserirPlanos(@Body PlanosModel p);
}
