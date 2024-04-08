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

        DefaultComboBoxModel modelo = new DefaultComboBoxModel(titulosPublicaciones.toArray());
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(nombresUsuariosSeguidos.toArray());
        JComboBox comboBoxPublicaciones = new JComboBox(modelo);
        JComboBox comboBoxSiguiendo = new JComboBox(modelo2);

        panel.add(comboBoxPublicaciones);
        panel.add(comboBoxSiguiendo);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(panel, BorderLayout.NORTH);

        panel.setVisible(true);
    }
}
