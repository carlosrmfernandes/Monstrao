package database.model;

public class Matriculas {
    public static final String
            TABELA_NAME = "matriculas";

    public static final String

            COLUNA_ID = "_id",
            COLUNA_CODIGOMATICULA = "codigo_matricula",
            COLUNA_CODIGOALUNO = "codigo_aluno",
            COLUNA_DATAMATRICULA  = "data_matricula",
            COLUNA_DATAVENCIMENTO  = "data_vencimento",
            COLUNA_DATAENCERRAMENTO  = "data_encerramento";



    public static final String
            CREATE_TABLE =
            "create table " + TABELA_NAME
                    + "("
                    + COLUNA_ID + " integer primary key autoincrement, "
                    + COLUNA_CODIGOMATICULA + " integer not null, "
                    + COLUNA_CODIGOALUNO + " integer not null, "
                    + COLUNA_DATAMATRICULA + " text not null, "
                    + COLUNA_DATAVENCIMENTO + " text, "
                    + COLUNA_DATAENCERRAMENTO + " text "
                    + ");";

    public static final String

            DROP_TABLE = " drop table if exists " + TABELA_NAME + ";";


    private int  codigo_matricula;
    private int  codigo_aluno;
    private String data_matricula;
    private String data_vencimento;
    private String data_encerramento;

    public int getCodigo_matricula() {
        return codigo_matricula;
    }

    public void setCodigo_matricula(int codigo_matricula) {
        this.codigo_matricula = codigo_matricula;
    }

    public int getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(int codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public String getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(String data_matricula) {
        this.data_matricula = data_matricula;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public String getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(String data_encerramento) {
        this.data_encerramento = data_encerramento;
    }
}
