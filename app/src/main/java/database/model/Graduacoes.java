package database.model;

public class Graduacoes {

    private static final String
            TABELA_NOME = "cidade";

    private static final String
            COLUNA_ID = "_id",
            COLUNA_CIDADE = "cidade",
            COLUNA_ESTADO= "estado",
            COLUNA_PAIS = "pais";


    public static final String
            CREATE_TABLE =
            "create table" + TABELA_NOME
                    + "("
                    + COLUNA_ID + "integer primary key autoincrement,"
                    + COLUNA_CIDADE + "text not null,"
                    + COLUNA_ESTADO+ "text not null,"
                    + COLUNA_PAIS+ "text not null,"
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

