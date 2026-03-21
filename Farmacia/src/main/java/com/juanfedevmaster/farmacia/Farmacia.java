/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.juanfedevmaster.farmacia;

/**
 *
 * @author juanfe
 */
public class Farmacia {

    public static void main(String[] args) {
    // Ejemplo de uso del proceso de ventas
    // Crear cliente y productos de ejemplo
    com.juanfedevmaster.farmacia.dominio.clientes.Cliente cliente =
        new com.juanfedevmaster.farmacia.dominio.clientes.Cliente(1, "Juan", "Pérez", "juan@email.com", "123456789");
    com.juanfedevmaster.farmacia.dominio.productos.Producto prod1 =
        new com.juanfedevmaster.farmacia.dominio.productos.Producto(1, "Paracetamol", "Analgésico", "LabX", 10.0, 100);
    com.juanfedevmaster.farmacia.dominio.productos.Producto prod2 =
        new com.juanfedevmaster.farmacia.dominio.productos.Producto(2, "Ibuprofeno", "Antiinflamatorio", "LabY", 15.0, 50);

    com.juanfedevmaster.farmacia.dominio.ventas.DetalleVenta detalle1 =
        new com.juanfedevmaster.farmacia.dominio.ventas.DetalleVenta(prod1, 2);
    com.juanfedevmaster.farmacia.dominio.ventas.DetalleVenta detalle2 =
        new com.juanfedevmaster.farmacia.dominio.ventas.DetalleVenta(prod2, 1);

    java.util.List<com.juanfedevmaster.farmacia.dominio.ventas.DetalleVenta> detalles = new java.util.ArrayList<>();
    detalles.add(detalle1);
    detalles.add(detalle2);

    com.juanfedevmaster.farmacia.servicio.ServicioVenta servicioVenta = new com.juanfedevmaster.farmacia.servicio.ServicioVenta();
    com.juanfedevmaster.farmacia.dominio.ventas.Venta venta = servicioVenta.registrarVenta(cliente, detalles);

    System.out.println("Venta registrada: " + venta);
    System.out.println("Detalles:");
    for (com.juanfedevmaster.farmacia.dominio.ventas.DetalleVenta d : venta.getDetalles()) {
        System.out.println("  " + d);
    }
    }
}
