package retrofit.model;

import java.io.Serializable;

public class PlanosModel  implements Serializable {

    private long id_modalidade;
    private String ds_plano;
    private Double valor ;
    private long IdConta;

    public long getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(long id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public String getDs_plano() {
        return ds_plano;
    }

    public void setDs_plano(String ds_plano) {
        this.ds_plano = ds_plano;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public long getIdConta() {
        return IdConta;
    }

    public void setIdConta(long idConta) {
        IdConta = idConta;
    }
}
