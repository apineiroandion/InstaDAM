package IntefazUsuario;

import FuncionamientoRed.*;
import UsuariosDePrueba.UsuariosPrueba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Login(Usuarios usuarios) {
        setTitle("Login");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Usuario
        JLabel usernameLabel = new JLabel("Usuario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField();
        usernameField.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(usernameField, gbc);

        // Contraseña
        JLabel passwordLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        passwordField.setColumns(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        // Botones
        JButton noLoginButton = new JButton("Entrar sin Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Ocupa dos columnas
        panel.add(noLoginButton, gbc);

        JButton loginButton = new JButton("Iniciar Sesión");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Ocupa dos columnas
        panel.add(loginButton, gbc);

        JButton crearCuenta = new JButton("Crear Cuenta");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Ocupa dos columnas
        panel.add(crearCuenta, gbc);

        add(panel);
        setVisible(true);

        crearCuenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                int comprobarNombre = 0;
                for (int i = 0; i < usuarios.getUsuarios().size(); i++) {
                    if(userName.equals(usuarios.getUsuarios().get(i).getUserName())){
                        comprobarNombre++;
                    }
                }
                if(comprobarNombre == 0){
                    usuarios.getUsuarios().add(new Usuario(userName, password));
                    JOptionPane.showMessageDialog(null, "Usuario registrado con exito");
                }else{
                    JOptionPane.showMessageDialog(null, "Nombre de usuario en uso, introduce otro");
                }
            }
        });
        //pendiente de añadir enlace a la nueva vetna de perfil
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());
                int contador = 0;
                for(int i = 0; i < usuarios.getUsuarios().size(); i++){
                    if(usuarios.getUsuarios().get(i).login(userName, password)){
                        contador++;
                        Perfil perfil = new Perfil(usuarios, usuarios.getUsuarios().get(i));
                        perfil.setVisible(true);
                    }
                }
                if(contador == 0){
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña erroneo");
                }
            }
        });
        noLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerTodasLasPublicaciones vtp = new VerTodasLasPublicaciones(usuarios);
                vtp.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        //Usuarios usuarios = UsuariosPrueba.crearUsuariosPrueba();;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login((UsuariosPrueba.crearUsuariosPrueba()));
            }
        });
    }
}