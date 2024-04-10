package FuncionamientoRed;

import java.util.ArrayList;

public class Usuarios {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    public Usuarios() {}

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<String> getUsuariosName() {
        ArrayList<String> usuariosName = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            usuariosName.add(usuario.getUserName());
        }
        return usuariosName;
    }
}
