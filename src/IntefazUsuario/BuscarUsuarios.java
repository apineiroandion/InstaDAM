package IntefazUsuario;

import FuncionamientoRed.Usuario;
import FuncionamientoRed.Usuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BuscarUsuarios extends JFrame {

    public BuscarUsuarios(Usuarios usuarios, Usuario usuario) {
        setTitle("Buscar Usuarios");
        setSize(300, 300);
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

        //ComboBox Usuarios
        Vector<String> data = new Vector<>(usuarios.getUsuariosName());
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(data);
        JComboBox comboUsuarios = new JComboBox(modelo);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(comboUsuarios, gbc);

        //Boton Seguir
        JButton botonSeguir = new JButton("Seguir");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(botonSeguir, gbc);
        botonSeguir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = comboUsuarios.getSelectedItem().toString();
                seguirUsuario(userName, usuarios, usuario);
                abrirPerfil(usuarios, usuario);
                dispose();
            }
        });

        //Boton Cancelar
        JButton botonCancelar = new JButton("Cancelar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(botonCancelar, gbc);
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPerfil(usuarios, usuario);
                dispose();
            }
        });

        add(panel);
        setVisible(true);
    }
    private void seguirUsuario(String userName,Usuarios usuarios, Usuario usuario){
        for (int i = 0; i < usuarios.getUsuarios().size(); i++){
            if (usuarios.getUsuarios().get(i).getUserName().equals(userName)){
                usuario.addSiguiendo(usuarios.getUsuarios().get(i));
                JOptionPane.showMessageDialog(null, "Has emepzado a seguir a "+usuarios.getUsuarios().get(i).getUserName());
            }
        }
    }
    private void abrirPerfil(Usuarios usuarios, Usuario usuario){
        Perfil perfil = new Perfil(usuarios, usuario);
        perfil.setVisible(true);
    }
}
