package com.juanfedevmaster.farmacia.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.juanfedevmaster.farmacia.dominio.clientes.Cliente;
import com.juanfedevmaster.farmacia.dominio.ventas.DetalleVenta;
import com.juanfedevmaster.farmacia.dominio.ventas.Venta;

/**
 * Servicio para gestionar el proceso de ventas en la farmacia.
 * Esta clase es autocontenida y puede adaptarse a futuras integraciones.
 */
public class ServicioVenta {
    private final List<Venta> ventas = new ArrayList<>();
    private int nextVentaId = 1;

    /**
     * Registra una nueva venta.
     * @param cliente Cliente que realiza la compra
     * @param detalles Lista de detalles de la venta
     * @return Venta registrada
     */
    public Venta registrarVenta(Cliente cliente, List<DetalleVenta> detalles) {
        Venta venta = new Venta(nextVentaId++, cliente);
        for (DetalleVenta detalle : detalles) {
            venta.agregarDetalle(detalle);
        }
        ventas.add(venta);
        return venta;
    }

    /**
     * Obtiene todas las ventas registradas.
     * @return Lista de ventas
     */
    public List<Venta> obtenerVentas() {
        return ventas;
    }

    /**
     * Busca una venta por su ID.
     * @param id ID de la venta
     * @return Venta encontrada o null si no existe
     */
    public Venta buscarVentaPorId(int id) {
        Optional<Venta> venta = ventas.stream().filter(v -> v.getId() == id).findFirst();
        return venta.orElse(null);
    }
}
