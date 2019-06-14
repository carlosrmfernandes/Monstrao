package retrofit.model;

import java.io.Serializable;
public class ModalidadeModel  implements Serializable  {

    private String nm_modalidade;
    private String Id;
    private long idConta;

    public String getNm_modalidade() {
        return nm_modalidade;
    }

    public void setNm_modalidade(String nm_modalidade) {
        this.nm_modalidade = nm_modalidade;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
    public void setIdConta(long idConta) {
        this.idConta = idConta;
    }
}


