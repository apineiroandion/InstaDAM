package IntefazUsuario;
import FuncionamientoRed.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class Perfil extends JFrame{
    //añadir
    Vector<String> data = new Vector<>();
    JComboBox comboBoxPublicaciones;
    DefaultComboBoxModel modelo;

    public Perfil(Usuarios usuarios, Usuario usuario){
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
        data = new Vector(usuario.listarTitulosPublicaciones());
        System.out.println(data.stream().reduce((s, s2) -> s + " , " + s2 ));
        //ComboBox de Publicaciones
        modelo = new DefaultComboBoxModel(data);
        comboBoxPublicaciones = new JComboBox(modelo);
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
        Vector<String> data2 = new Vector(usuario.listarUsuariosSiguiendo());
        System.out.println(data2.stream().reduce((s, s2) -> s + " , " + s2 ));
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(data2);
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
                pruebaArray(usuario.getPublicaciones());
                dataChanged(new Vector<>(usuario.listarTitulosPublicaciones()));
                dispose();
            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(panel, BorderLayout.NORTH);

        panel.setVisible(true);
    }

    public void dataChanged(Vector<String> data){
        this.data = data;
    }

    private void pruebaArray (ArrayList lista){
        System.out.println("Prueba Array");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i)+" item");
        }
    }
}
