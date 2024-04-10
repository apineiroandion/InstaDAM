package IntefazUsuario;
import FuncionamientoRed.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Perfil extends JFrame{
    public Perfil(Usuarios usuarios, Usuario usuario){
        ArrayList<String> titulosPublicaciones = usuario.listarTitulosPublicaciones();
        ArrayList<String> nombresUsuariosSeguidos = usuario.listarUsuariosSiguiendo();
        setTitle("Perfil Usuario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel(usuario.getUserName());
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        //Label Publicaciones
        JLabel publicacionesLabel = new JLabel("Tus publicaciones");
        publicacionesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(publicacionesLabel, gbc);

        //ComboBox de Publicaciones
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(titulosPublicaciones.toArray());
        JComboBox comboBoxPublicaciones = new JComboBox(modelo);
        comboBoxPublicaciones.setPreferredSize(new Dimension(150, 20));
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(comboBoxPublicaciones, gbc);

        //Boton de añadir publicacion
        JButton nuevaPublicacion = new JButton("Nueva Publicacion");
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(nuevaPublicacion, gbc);

        //Label Seguidores
        JLabel seguidoresLabel = new JLabel("Perfiles que sigues");
        seguidoresLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(seguidoresLabel, gbc);

        //ComboBox de Seguidores
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(nombresUsuariosSeguidos.toArray());
        JComboBox comboBoxSiguiendo = new JComboBox(modelo2);
        comboBoxSiguiendo.setPreferredSize(new Dimension(150, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(comboBoxSiguiendo, gbc);

        //Boton para buscar usuarios
        JButton buscarUsuario = new JButton("Buscar Usuario");
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(buscarUsuario, gbc);


        nuevaPublicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CrearPublicacion cp = new CrearPublicacion(usuarios, usuario);
                cp.setVisible(true);
            }
        });






        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(panel, BorderLayout.NORTH);

        panel.setVisible(true);
    }
}
