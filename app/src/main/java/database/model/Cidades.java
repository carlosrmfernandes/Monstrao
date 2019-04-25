package database.model;

public class Cidades {

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



    private String cidade;
    private String estado;
    private String pais;


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
