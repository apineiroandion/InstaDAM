package IntefazUsuario;
import FuncionamientoRed.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Perfil extends JFrame{
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

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        add(panel, BorderLayout.NORTH);

        panel.setVisible(true);
    }
}
