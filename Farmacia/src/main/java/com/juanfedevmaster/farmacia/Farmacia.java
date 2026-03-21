/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.juanfedevmaster.farmacia;

import javax.swing.*;

/**
 *
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

        // Menú Ventas
        JMenu menuVentas = new JMenu("Ventas");
        JMenuItem itemRegistroVenta = new JMenuItem("Registro de venta");
        itemRegistroVenta.addActionListener(e -> {
            // Funcionalidad en desarrollo: aún no implementada.
            JOptionPane.showMessageDialog(this, "Funcionalidad de registro de venta pendiente de implementar.", "Registro de venta", JOptionPane.INFORMATION_MESSAGE);
        });
        menuVentas.add(itemRegistroVenta);

        // Menú Salir
        JMenu menuSalir = new JMenu("Archivo");
        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> System.exit(0));
        menuSalir.add(itemSalir);

        menuBar.add(menuCliente);
        menuBar.add(menuVentas);
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
