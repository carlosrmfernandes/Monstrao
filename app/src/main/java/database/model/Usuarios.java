package database.model;

public class Usuarios {

    private static final String
            TABELA_NAME = "usuario";

    public static final String
            COLUNA_ID = "_id",
            COLUNA_USARIO = "usuario",
            COLUNA_PERFIL = "perfil";

    public static final String
            CREAT_TABLE =
            "create table" + TABELA_NAME
                    + "("
                    + COLUNA_ID + "integer primary kay autoincrement,"
                    + COLUNA_USARIO + " text not null,"
                    + COLUNA_PERFIL + " text not null,"
                    + ");";

    public static final String

            DROP_TABLE = " drop table if exists" + TABELA_NAME + ";";


    private String usuario;
    private String perfil;


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
}





