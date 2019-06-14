package retrofit.model;

import java.io.Serializable;

public class GraduacoesModel  implements Serializable {

    private long  id_modalidade;
    private String ds_graduacao;
    private long IdConta;

    public long getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(long id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public String getDs_graduacao() {
        return ds_graduacao;
    }

    public void setDs_graduacao(String ds_graduacao) {
        this.ds_graduacao = ds_graduacao;
    }

    public long getIdConta() {
        return IdConta;
    }

    public void setIdConta(long idConta) {
        IdConta = idConta;
    }
}
