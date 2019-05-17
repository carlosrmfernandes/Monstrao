package database.model;

public class Graduacoes {

    public static final String
            TABELA_NOME = "graducoes";

    public static final String
            COLUNA_ID = "_id",
            GRADUACAO= "graducao",
            MODALIDADE = "modalidade";

    public static final String
            CREATE_TABLE =
            "create table " + TABELA_NOME
                    + "("
                    + COLUNA_ID + " integer primary key autoincrement, "
                    + MODALIDADE + " text not null, "
                    + GRADUACAO+ " text not null "
                    + ");";

    public static final String
            Drop_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private String  modalidade;
    private String graduacao;
    private String id;


    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

