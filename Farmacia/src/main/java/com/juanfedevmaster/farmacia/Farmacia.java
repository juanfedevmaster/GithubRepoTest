package com.juanfedevmaster.farmacia;

import javax.swing.*;

/**
 * Sistema de Farmacia - Programa principal
 * @author juanfe
 */
public class Farmacia extends JFrame {

    private JDesktopPane desktopPane;
    private JMenuBar menuBar;

    public Farmacia() {
        // Configurar la ventana principal
        setTitle("Sistema de Gestión Farmacia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Crear el escritorio MDI
        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new java.awt.Color(240, 240, 240));
        setContentPane(desktopPane);

        // Crear y establecer la barra de menú
        crearMenuBar();
        setJMenuBar(menuBar);

        // Mostrar la ventana
        setVisible(true);
    }

    private void crearMenuBar() {
        menuBar = new JMenuBar();

        // Menú Cliente
        JMenu menuCliente = new JMenu("Clientes");
        JMenuItem itemRegistrar = new JMenuItem("Registrar Cliente");
        itemRegistrar.addActionListener(e -> abrirRegistroCliente());
        menuCliente.add(itemRegistrar);

        // Menú Salir
        JMenu menuSalir = new JMenu("Archivo");
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0));
        menuSalir.add(itemSalir);

        menuBar.add(menuCliente);
        menuBar.add(menuSalir);
    }

    private void abrirRegistroCliente() {
        // Crear la ventana interna para registrar cliente
        RegistroClienteFrame registroFrame = new RegistroClienteFrame();
        desktopPane.add(registroFrame);
        registroFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Farmacia());
    }
}
