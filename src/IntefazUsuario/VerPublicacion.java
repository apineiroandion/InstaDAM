package IntefazUsuario;

import FuncionamientoRed.Publicacion;

import javax.swing.*;
import java.awt.*;

public class VerPublicacion extends JFrame {
    public VerPublicacion(Publicacion publicacion) {
        setTitle(publicacion.getTitulo());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(volver, gbc);

        panel.setVisible(true);
        setVisible(true);
    }
}
