package com.juanfedevmaster.farmacia;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana interna para registrar un nuevo cliente
 * @author juanfe
 */
public class RegistroClienteFrame extends JInternalFrame {

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnCancelar;

    public RegistroClienteFrame() {
        setTitle("Registrar Nuevo Cliente");
        setSize(500, 350);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        setMaximizable(true);
        setIconifiable(true);
        setClosable(true);

        // Crear el panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Crear el panel de formulario
        JPanel panelFormulario = crearPanelFormulario();

        // Crear el panel de botones
        JPanel panelBotones = crearPanelBotones();

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }

    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta y campo Nombre
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        JLabel lblNombre = new JLabel("Nombre:");
        panel.add(lblNombre, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtNombre = new JTextField(20);
        panel.add(txtNombre, gbc);

        // Etiqueta y campo Apellido
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        JLabel lblApellido = new JLabel("Apellido:");
        panel.add(lblApellido, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtApellido = new JTextField(20);
        panel.add(txtApellido, gbc);

        // Etiqueta y campo Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        JLabel lblEmail = new JLabel("Email:");
        panel.add(lblEmail, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtEmail = new JTextField(20);
        panel.add(txtEmail, gbc);

        // Etiqueta y campo Teléfono
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0;
        JLabel lblTelefono = new JLabel("Teléfono:");
        panel.add(lblTelefono, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        txtTelefono = new JTextField(20);
        panel.add(txtTelefono, gbc);

        return panel;
    }

    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        btnGuardar = new JButton("Guardar");
        btnLimpiar = new JButton("Limpiar");
        btnCancelar = new JButton("Cancelar");

        btnCancelar.addActionListener(e -> this.dispose());

        panel.add(btnGuardar);
        panel.add(btnLimpiar);
        panel.add(btnCancelar);

        return panel;
    }
}
