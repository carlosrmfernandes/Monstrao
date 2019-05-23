package database.model;

public class Modalidades {
    public static final String
            TABELA_NOME = "modalidades";

    public static final String

            COLUNA_ID = "_id",
            COLUNA_MODALIDAE = "modalidade";

    public static final String
            CREATE_TABLE =
            "create table " + TABELA_NOME
                    + "("
                    + COLUNA_ID + "  integer primary key autoincrement, "
                    + COLUNA_MODALIDAE + "  text not null "
                    + ");";

    public static final String

            DROP_TABLE = " drop table if exists " + TABELA_NOME + ";";


    private String modalidade;
    private String id;

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
