package IntefazUsuario;

import FuncionamientoRed.Usuario;
import FuncionamientoRed.Usuarios;

import javax.swing.*;
import java.awt.*;

public class BuscarUsuarios extends JFrame {

    public BuscarUsuarios(Usuarios usuarios, Usuario usuario) {
        setTitle("Buscar Usuarios");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        //Label para buscar usuarios
        JLabel labelUsuario = new JLabel("Usuarios");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelUsuario, gbc);
        //TODO: combo box de usuarios de la red
        //ComboBox Usuarios
        //TODO: boton de seguir

        add(panel);
        setVisible(true);
    }
}
