package UsuariosDePrueba;


import FuncionamientoRed.*;

public class UsuariosPrueba {
    public static Usuarios crearUsuariosPrueba() {
        Usuarios usuarios = new Usuarios();
        int idUsuario = 0;
        usuarios.getUsuarios().add(new Usuario("angel","123"));
        usuarios.getUsuarios().add(new Usuario("pepe","123"));
        usuarios.getUsuarios().add(new Usuario("juan","123"));
        usuarios.getUsuarios().add(new Usuario("manolo","123"));
        for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
            if (usuarios.getUsuarios().get(i).getUserName().equals("angel")) {
                idUsuario = i;
            }
        }
        Usuario angel = usuarios.getUsuarios().get(idUsuario);
        angel.addPublicacion(new Publicacion("publicacion1","publicacion1"));
        angel.addPublicacion(new Publicacion("publicacion2","publicacion2"));
        angel.addPublicacion(new Publicacion("publicacion3","publicacion3"));
        angel.addPublicacion(new Publicacion("publicacion4","publicacion4"));

        angel.addSiguiendo(usuarios.getUsuarios().get(1));
        angel.addSiguiendo(usuarios.getUsuarios().get(2));
        angel.addSiguiendo(usuarios.getUsuarios().get(3));

        return usuarios;




        /*Usuario usuriousPrue = new Usuario("angel", "123");
        usuriousPrue.addPublicacion(new Publicacion("publicacion1","publicacion1"));
        usuriousPrue.addPublicacion(new Publicacion("publicacion2","publicacion2"));
        usuriousPrue.addPublicacion(new Publicacion("publicacion3","publicacion3"));
        usuriousPrue.addPublicacion(new Publicacion("publicacion4","publicacion4"));

        usuriousPrue.addSiguiendo(new Usuario("pepe","123"));
        usuriousPrue.addSiguiendo(new Usuario("juan","123"));
        usuriousPrue.addSiguiendo(new Usuario("manolo","123"));*/
    }


}
