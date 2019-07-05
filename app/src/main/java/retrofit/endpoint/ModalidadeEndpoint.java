package retrofit.endpoint;


import java.util.List;

import retrofit.model.ModalidadeModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ModalidadeEndpoint {

    @GET ("api/unesc/modalidade/buscar")
    Call<List<ModalidadeModel>> buscarModalidade(@Query("id_conta") long id_conta);

    @POST("api/unesc/modalidade/incluir")
    Call<Long> inserirModalidade(@Body ModalidadeModel m);

    @POST("api/unesc/modalidade/excluir")
    Call<Boolean> deleteModalida(@Query("id_modalidade") long id_modalidade);
}
