package IntefazUsuario;

import FuncionamientoRed.Publicacion;
import FuncionamientoRed.Usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class VerTodasLasPublicaciones extends JFrame {
    Vector<String> data;
    JComboBox comboBoxPublicaciones;
    DefaultComboBoxModel modelo;

    public VerTodasLasPublicaciones(Usuarios usuarios) {
        setTitle("Ver Publicaciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        JLabel publicacionesLabel = new JLabel("Publicaciones");
        publicacionesLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(publicacionesLabel, gbc);

        //ComboBoxPublicaciones
        data = new Vector<>(usuarios.getAllPublicacionesTitulo(usuarios.getAllPublicaciones()));
        modelo = new DefaultComboBoxModel(data);
        comboBoxPublicaciones = new JComboBox(modelo);
        comboBoxPublicaciones.setPreferredSize(new Dimension(150, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(comboBoxPublicaciones, gbc);

        //Boton Ver Publicaciones
        JButton verPublicaciones = new JButton("Ver Publicacion");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(verPublicaciones, gbc);

        verPublicaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = comboBoxPublicaciones.getSelectedIndex();
                Publicacion publicacion = usuarios.getAllPublicaciones().get(index);
                VerPublicacionAjena verPublicacionAjena = new VerPublicacionAjena(publicacion, usuarios);
                verPublicacionAjena.setVisible(true);
            }
        });


        add(panel);
        panel.setVisible(true);
        setVisible(true);
    }
}
