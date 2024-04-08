package FuncionamientoRed;

import java.util.ArrayList;

public class Usuario {
    private String userName;
    private String password;
    private ArrayList<Publicacion> publicaciones;
    private ArrayList<Usuario> siguiendo;

    public Usuario(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.publicaciones = new ArrayList<>();
        this.siguiendo = new ArrayList<>();
    }

    public boolean login(String userName, String password){
        if(userName.equals(this.userName) && password.equals(this.password)){
            return true;
        }else return false;
    }
    public Publicacion getPublicacion(String titulo, String descripcion){
        Publicacion publicacion = new Publicacion(titulo, descripcion);
        return publicacion;
    }
    public void addPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
    }

    public void addSiguiendo(Usuario usuario){
        this.siguiendo.add(usuario);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
        this.publicaciones = publicaciones;
    }
}
