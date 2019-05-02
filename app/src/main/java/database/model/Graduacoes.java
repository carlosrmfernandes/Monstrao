package database.model;

public class Graduacoes {

    public static final String
            TABELA_NOME = "cidade";

    public static final String
            COLUNA_ID = "_id",
            MODALIDADE = "cidade",
            GRADUACAO= "estado";



    public static final String
            CREATE_TABLE =
            "create table" + TABELA_NOME
                    + "("
                    + COLUNA_ID + "integer primary key autoincrement,"
                    + MODALIDADE + "text not null,"
                    + GRADUACAO+ "text not null,"
                    + ");";

    public static final String
            Drop_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private String  modalidade;
    private String graduacao;


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
}

