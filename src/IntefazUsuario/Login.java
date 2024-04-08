package IntefazUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        JLabel usernameLabel = new JLabel("Usuario:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Iniciar Sesión");
        JButton noLoginButton = new JButton("Continuar sin Login");
        JButton crearCuenrta = new JButton("Crear Cuenta");


        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(new JLabel());
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel());
        panel.add(noLoginButton);
        panel.add(loginButton);
        panel.add(crearCuenrta);


        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Aquí puedes agregar la lógica de autenticación
                // Por ahora solo imprimiremos los valores ingresados
                System.out.println("Usuario: " + username);
                System.out.println("Contraseña: " + password);
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}