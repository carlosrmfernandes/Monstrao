package database.model;

public class Planos {

    private static final String
            TABELA_NAME = "planos";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_MODALIDAE = "modalidade",
            COLUNA_PLANO = "plano",
            COLUNA_VALORMENSAL = "valor mensal";


    public static final String
            CREAT_TABLE =
            "create table" + TABELA_NAME
                    + "("
                    + COLUNA_ID + "integer primary kay autoincrement,"
                    + COLUNA_MODALIDAE + " text not null,"
                    + COLUNA_PLANO + " text not null,"
                    + COLUNA_PLANO + " text not null,"
                    + ");";

    public static final String

            DROP_TABLE = " drop table if exists" + TABELA_NAME + ";";


    private String modalidade;
    private String plano;
    private Double valor_mensal;


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
}

