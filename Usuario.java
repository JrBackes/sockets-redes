public class Usuario {

    int id;
    String usuario;
    String password;

    public Usuario(int identificador, String user, String pass){
        id = identificador;
        usuario = user;
        password = pass;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }
    public String getPassword() {
        return password;
    }


}
