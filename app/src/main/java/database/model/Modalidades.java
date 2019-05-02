package database.model;

public class Modalidades {
    public static final String
            TABELA_NOME = "modalidades";

    public static final String

            COLUNA_ID = "_id",
            COLUNA_MODALIDAE = "modalidade";

    public static final String
            CREAT_TABLE =
            "create table" + TABELA_NOME
                    + "("
                    + COLUNA_ID + "integer primary kay autoincrement,"
                    + COLUNA_MODALIDAE + " text not null,"
            +");";

    public static final String

            DROP_TABLE = " drop table if exists" + TABELA_NOME + ";";


    private String modalidade;
    String teste;

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
}
