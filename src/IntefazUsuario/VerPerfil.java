package IntefazUsuario;

import FuncionamientoRed.Usuario;
import FuncionamientoRed.Usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class VerPerfil extends JFrame {
    Vector<String> data;
    JComboBox comboBoxPublicaciones;
    DefaultComboBoxModel modelo;
    Vector<String> data2;
    DefaultComboBoxModel modelo2;
    JComboBox comboBoxSiguiendo;

    public VerPerfil(Usuarios usuarios, Usuario usuario){
        setTitle("Perfil Usuario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        //Boton para ver publicacion
        JButton verPublicacion = new JButton("Ver Publicacion");
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(verPublicacion, gbc);


        //Label Seguidores
        JLabel seguidoresLabel = new JLabel("Perfiles que sigues");
        seguidoresLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(seguidoresLabel, gbc);

        //ComboBox de Seguidores
        data2 = new Vector(usuario.listarUsuariosSiguiendo());
        System.out.println(data2.stream().reduce((s, s2) -> s + " , " + s2 ));
        modelo2 = new DefaultComboBoxModel(data2);
        comboBoxSiguiendo = new JComboBox(modelo2);

        comboBoxSiguiendo.setPreferredSize(new Dimension(150, 20));
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(comboBoxSiguiendo, gbc);

        verPublicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = comboBoxPublicaciones.getSelectedItem().toString();
                int indice = 0;
                int contador = 0;
                for (int i = 0; i < usuario.getPublicaciones().size(); i++) {
                    if (titulo.equals(usuario.getPublicaciones().get(i).getTitulo())) {
                        indice = i;
                        contador++;
                    }
                }
                if (contador != 0){
                    VerPublicacionAjena verPublicacionAjena = new VerPublicacionAjena(usuario.getPublicaciones().get(indice), usuario, usuarios);
                    verPublicacionAjena.setVisible(true);
                }

            }
        });

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(panel, BorderLayout.NORTH);

        panel.setVisible(true);
    }

    public void dataChanged(Vector<String> data){
        this.data = data;
    }
    public void data2Changed(Vector<String> data2){
        this.data2 = data2;
    }

    private void pruebaArray (ArrayList lista){
        System.out.println("Prueba Array");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i)+" item");
        }
    }
}
