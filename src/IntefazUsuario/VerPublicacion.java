package IntefazUsuario;

import FuncionamientoRed.Publicacion;
import FuncionamientoRed.Usuario;
import FuncionamientoRed.Usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerPublicacion extends JFrame {
    public VerPublicacion(Publicacion publicacion, Usuario usuario, Usuarios usuarios) {
        setTitle(publicacion.getTitulo());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        JLabel titulo = new JLabel("Titulo "+publicacion.getTitulo());
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(titulo, gbc);

        JLabel descripcion = new JLabel("Descripcion "+publicacion.getDescripcion());
        descripcion.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(descripcion, gbc);

        JButton borrar = new JButton("Borrar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(borrar, gbc);

        JButton volver = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(volver, gbc);

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.getPublicaciones().remove(publicacion);
                abrirPerfil(usuarios, usuario);
                dispose();
            }
        });

        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPerfil(usuarios, usuario);
                dispose();
            }
        });


        add(panel);
        panel.setVisible(true);
        setVisible(true);
    }
    private void abrirPerfil(Usuarios usuarios, Usuario usuario){
        Perfil perfil = new Perfil(usuarios, usuario);
        perfil.setVisible(true);
    }
}
