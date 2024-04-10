package IntefazUsuario;

import FuncionamientoRed.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearPublicacion extends JFrame {
    public CrearPublicacion(Usuarios usuarios, Usuario usuario){
        setTitle("Crear Publicacion");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Titulo Label
        JLabel tituloLabel = new JLabel("Titulo: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(tituloLabel, gbc);

        // Titulo TextField
        JTextField tituloField = new JTextField();
        tituloField.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(tituloField, gbc);

        // Descripcion Label
        JLabel descripcionLabel = new JLabel("Descripcion: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(descripcionLabel, gbc);

        // Descripcion TextField
        JTextField descripcionField = new JTextField();
        descripcionField.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(descripcionField, gbc);

        //Boton Confirmacion
        JButton confirmarButton = new JButton("Publicar");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(confirmarButton, gbc);

        //Boton Cancelar
        JButton cancelarButton = new JButton("Cancelar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(cancelarButton, gbc);

        //Listener de crearPublicacion
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText();
                String descripcion = descripcionField.getText();
                crearPublicacion(usuario, titulo, descripcion);
                abrirPerfil(usuarios, usuario);
                dispose();
            }
        });

        //Listener de Cacelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPerfil(usuarios, usuario);
                dispose();
            }
        });

        //Visualizar Panel
        add(panel, BorderLayout.NORTH);
        panel.setVisible(true);
    }
    private void abrirPerfil(Usuarios usuarios, Usuario usuario){
        Perfil perfil = new Perfil(usuarios, usuario);
        perfil.setVisible(true);
    }
    private void crearPublicacion(Usuario usuario, String titulo, String descripcion){
        usuario.addPublicacion(new Publicacion(titulo, descripcion));
        JOptionPane.showMessageDialog(this, "Publicacion creada");
    }
}