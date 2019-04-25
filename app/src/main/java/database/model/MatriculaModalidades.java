package database.model;

public class MatriculaModalidades {

    private static final String
            TABELA_NOME = "matricula_modalidade";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_CODIGO_MATRICULA = "codigo_matricula",
            COLUNA_MODALIDADE= "modalidade",
            COLUNA_PLANO = "plano",
            COLUNA_DATA_INICIO= "data_inicio",
            COLUNA_DATA_FIM= "data_fim";


    public static final String
            CREATE_TABLE =
            "create table" + TABELA_NOME
                    + "("
                    + COLUNA_ID + "integer primary key autoincrement,"
                    + COLUNA_CODIGO_MATRICULA+ "text not null,"
                    + COLUNA_MODALIDADE+ "text not null,"
                    + COLUNA_PLANO+ "text not null,"
                    + COLUNA_DATA_INICIO+ "text not null,"
                    + COLUNA_DATA_FIM+ "text not null,"
                    + ");";

    public static final String
            Drop_TABLE = "drop table if exists " + TABELA_NOME + ";";



    private int codigo_matricula;
    private String modalidade;
    private String  graduação;
    private String  plano;
    private String  data_inicio;
    private String  data_fim;


    public int getCodigo_matricula() {
        return codigo_matricula;
    }

    public void setCodigo_matricula(int codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getGraduação() {
        return graduação;
    }

    public void setGraduação(String graduação) {
        this.graduação = graduação;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_fim() {
        return data_fim;
    }

    public void setData_fim(String data_fim) {
        this.data_fim = data_fim;
    }
}
