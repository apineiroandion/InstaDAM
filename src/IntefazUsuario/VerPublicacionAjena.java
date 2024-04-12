package IntefazUsuario;

import FuncionamientoRed.Publicacion;
import FuncionamientoRed.Usuario;
import FuncionamientoRed.Usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerPublicacionAjena extends JFrame {
    public VerPublicacionAjena(Publicacion publicacion, Usuario usuario, Usuarios usuarios) {
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


        JButton volver = new JButton("Volver");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(volver, gbc);


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
