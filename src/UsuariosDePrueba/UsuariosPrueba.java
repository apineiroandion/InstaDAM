package UsuariosDePrueba;


import FuncionamientoRed.Usuario;

public class UsuariosPrueba {
    public static void crearUsuariosPrueba() {
        Usuario usuarioPrueba = new Usuario("angel", "123");
        usuarioPrueba.addPublicacion("publicacion1","publicacion1");
        usuarioPrueba.addPublicacion("publicacion2","publicacion2");
        usuarioPrueba.addPublicacion("publicacion3","publicacion3");
        usuarioPrueba.addPublicacion("publicacion4","publicacion4");

        usuarioPrueba.addSiguiendo(new Usuario("pepe","123"));
        usuarioPrueba.addSiguiendo(new Usuario("juan","123"));
        usuarioPrueba.addSiguiendo(new Usuario("manolo","123"));
    }


}
