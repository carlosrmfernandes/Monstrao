package database.model;

public class Assiduidade {

    private static final String
            TABELA_NOME = "assiduidade";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_CODIGO_MaTRICULA = "codigo_matricula",
            COLUNA_DATA_ENTRADA = "data_entrada";


    public static final String
            CREATE_TABLE =
            "create table" + TABELA_NOME
                    + "("
                    + COLUNA_ID + "integer primary key autoincrement,"
                    + COLUNA_CODIGO_MaTRICULA + "text not null,"
                    + COLUNA_DATA_ENTRADA + "text not null,"
                    + ");";

    public static final String
            Drop_TABLE = "drop table if exists " + TABELA_NOME + ";";




    private int codigo_matricula;
    private String data_entrada;


    public int getCodigo_matricula() {
        return codigo_matricula;
    }

    public void setCodigo_matricula(int codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }
}
