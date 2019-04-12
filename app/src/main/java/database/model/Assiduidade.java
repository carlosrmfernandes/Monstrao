package database.model;

public class Assiduidade {
    private int codigo_matricula;
    private String data_entrada;
    String teste;

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
