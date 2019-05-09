package database.model;

public class Usuarios {

    public static final String
            TABELA_NOME = "usuario";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_USARIO = "usuario",
            COLUNA_PERFIL = "perfil",
            COLUNA_NOME = "nome",
            COLUNA_SOBRENOME = "sobrenome",
            COLUNA_SENHA = "senha";


    public static final String
            CREAT_TABLE =
            "create table " + TABELA_NOME
                    + "("
                    + COLUNA_ID + " integer primary key autoincrement, "
                    + COLUNA_USARIO + " text not null, "
                    + COLUNA_PERFIL + " text not null, "
                    + COLUNA_NOME + " text not null, "
                    + COLUNA_SOBRENOME + " text not null, "
                    + COLUNA_SENHA + " text not null "
                    + ");";

    public static final String
            DROP_TABLE = " drop table if exists" + TABELA_NOME + ";";


    private String usuario;
    private String perfil;
    private String nome;
    private String sobreNome;
    private String senha;
    private String id;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}





