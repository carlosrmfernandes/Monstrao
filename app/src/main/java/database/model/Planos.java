package database.model;

public class Planos {

    public static final String
            TABELA_NOME = "planos";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_MODALIDAE = "modalidade",
            COLUNA_PLANO = "plano",
            COLUNA_VALORMENSAL = "valor_mensal";


    public static final String
            CREATE_TABLE =
            "create table " + TABELA_NOME
                    + "("
                    + COLUNA_ID + " integer primary key autoincrement, "
                    + COLUNA_MODALIDAE + " text not null, "
                    + COLUNA_PLANO + " text not null, "
                    + COLUNA_VALORMENSAL + " text not null "
                    + ");";

    public static final String

            DROP_TABLE = " drop table if exists " + TABELA_NOME + ";";


    private String modalidade;
    private String plano;
    private Double valor_mensal;
    private String id;


    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public Double getValor_mensal() {
        return valor_mensal;
    }

    public void setValor_mensal(Double valor_mensal) {
        this.valor_mensal = valor_mensal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

