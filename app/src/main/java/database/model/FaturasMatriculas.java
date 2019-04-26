package database.model;

public class FaturasMatriculas {

    public static final String
            TABELA_NOME = "faturas_matriculas";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_FATURA_MATRICULA = "faturas_matriculas",
            COLUNA_DATA_VENCIMENTO= "data_vencimento",
            COLUNA_VALOR = "valor",
            COLUNA_DATA_PAGAMENTO= "data_pagamento",
            COLUNA_DATA_CANCELAMENTO= "data_cancelamento";


    public static final String
            CREATE_TABLE =
            "create table" + TABELA_NOME
                    + "("
                    + COLUNA_ID + "integer primary key autoincrement,"
                    + COLUNA_FATURA_MATRICULA + "text not null,"
                    + COLUNA_DATA_VENCIMENTO+ "text not null,"
                    + COLUNA_VALOR+ "text not null,"
                    + COLUNA_DATA_PAGAMENTO+ "text not null,"
                    + COLUNA_DATA_CANCELAMENTO+ "text not null,"
                    + ");";

    public static final String
            Drop_TABLE = "drop table if exists " + TABELA_NOME + ";";

    private int faturas_matriculas;
    private String data_vencimento;
    private double valor;
    private  String data_pagamento;
    private String data_cancelamento;


    public int getFaturas_matriculas() {
        return faturas_matriculas;
    }

    public void setFaturas_matriculas(int faturas_matriculas) {
        this.faturas_matriculas = faturas_matriculas;
    }

    public String getData_vencimento() {
        return data_vencimento;
    }

    public void setData_vencimento(String data_vencimento) {
        this.data_vencimento = data_vencimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(String data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public String getData_cancelamento() {
        return data_cancelamento;
    }

    public void setData_cancelamento(String data_cancelamento) {
        this.data_cancelamento = data_cancelamento;
    }
}
