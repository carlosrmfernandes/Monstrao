package database.model;

public class Alunos {

    private static final String
            TABELA_NOME = "pessoa";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_CODIGO_ALUNO = "codigo_aluno",
            COLUNA_NOME = "nome",
            COLUNA_DATA_NASCIMENTO = "data_nascimento",
            COLUNA_SEXO = "sexo",
            COLUNA_TELEFONE = "telefone",
            COLUNA_CELULAR = "celular",
            COLUNA_EMAIL = "email",
            COLUNA_OBSERVACAO = "observacao",
            COLUNA_ENDERECO = "endereco",
            COLUNA_NUMERO = "numero",
            COLUNA_COMPLEMENTO = "complemento",
            COLUNA_BAIRRO = "bairro",
            COLUNA_CIDADE = "cidade",
            COLUNA_ESTADO = "estado",
            COLUNA_PAIS = "pais",
            COLUNA_CEP = "cep";

    public static final String
            CREATE_TABLE =
            "create table" + TABELA_NOME
                    + "("
                    + COLUNA_ID + "integer primary key autoincrement,"
                    + COLUNA_CODIGO_ALUNO + "text not null,"
                    + COLUNA_NOME + "text not null,"
                    + COLUNA_DATA_NASCIMENTO + "text not null,"
                    + COLUNA_SEXO + "text not null,"
                    + COLUNA_TELEFONE + "text not null,"
                    + COLUNA_CELULAR + "text not null,"
                    + COLUNA_EMAIL + "text not null,"
                    + COLUNA_OBSERVACAO + "text not null,"
                    + COLUNA_ENDERECO + "text not null,"
                    + COLUNA_NUMERO + "text not null,"
                    + COLUNA_COMPLEMENTO + "text not null,"
                    + COLUNA_BAIRRO + "text not null,"
                    + COLUNA_CIDADE + "text not null,"
                    + COLUNA_ESTADO + "text not null,"
                    + COLUNA_PAIS + "text not null,"
                    + COLUNA_CEP + "text not null,"
                    + ");";

    public static final String
            Drop_TABLE = "drop table if exists " + TABELA_NOME + ";";


    private String codigo_aluno;
    private String nome;
    private String data_nascimento;
    private String sexo;
    private String telefone;
    private String celular;
    private String email;
    private String observacao;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private int cidade;
    private int estado;
    private int pais;
    private String cep;


    public String getCodigo_aluno() {
        return codigo_aluno;
    }

    public void setCodigo_aluno(String codigo_aluno) {
        this.codigo_aluno = codigo_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
