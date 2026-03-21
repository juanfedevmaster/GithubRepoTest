package com.juanfedevmaster.farmacia.servicios;

import com.juanfedevmaster.farmacia.dominio.clientes.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar el registro de clientes
 */
public class RegistroClientes {

    private List<Cliente> clientes;
    private int proximoId;

    public RegistroClientes() {
        this.clientes = new ArrayList<>();
        this.proximoId = 1;
    }

    /**
     * Registra un nuevo cliente en el sistema
     */
    public Cliente registrarCliente(String nombre, String apellido, String email, String telefono) {
        // Validar que el email sea único
        if (buscarPorEmail(email).isPresent()) {
            throw new IllegalArgumentException("El email " + email + " ya está registrado");
        }

        Cliente cliente = new Cliente(proximoId++, nombre, apellido, email, telefono);
        clientes.add(cliente);
        System.out.println("✓ Cliente registrado: " + cliente.getNombreCompleto());
        return cliente;
    }

    /**
     * Busca un cliente por ID
     */
    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    /**
     * Busca un cliente por email
     */
    public Optional<Cliente> buscarPorEmail(String email) {
        return clientes.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    /**
     * Busca clientes por nombre o apellido
     */
    public List<Cliente> buscarPorNombre(String termino) {
        return clientes.stream()
                .filter(c -> c.getNombre().toLowerCase().contains(termino.toLowerCase()) ||
                        c.getApellido().toLowerCase().contains(termino.toLowerCase()))
                .toList();
    }

    /**
     * Obtiene todos los clientes registrados
     */
    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes);
    }

    /**
     * Actualiza los datos de un cliente
     */
    public void actualizarCliente(int id, String nombre, String apellido, String email, String telefono) {
        Optional<Cliente> clienteOpt = buscarPorId(id);
        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            System.out.println("✓ Cliente actualizado: " + cliente.getNombreCompleto());
        } else {
            throw new IllegalArgumentException("Cliente con ID " + id + " no encontrado");
        }
    }

    /**
     * Elimina un cliente del registro
     */
    public void eliminarCliente(int id) {
        boolean eliminado = clientes.removeIf(c -> c.getId() == id);
        if (eliminado) {
            System.out.println("✓ Cliente eliminado correctamente");
        } else {
            throw new IllegalArgumentException("Cliente con ID " + id + " no encontrado");
        }
    }

    /**
     * Obtiene la cantidad de clientes registrados
     */
    public int obtenerCantidadClientes() {
        return clientes.size();
    }

    /**
     * Lista todos los clientes de forma legible
     */
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados");
            return;
        }

        System.out.println("\n========== LISTADO DE CLIENTES ==========");
        System.out.printf("%-5s %-20s %-20s %-30s %-15s%n", "ID", "NOMBRE", "APELLIDO", "EMAIL", "TELÉFONO");
        System.out.println("-".repeat(90));

        for (Cliente cliente : clientes) {
            System.out.printf("%-5d %-20s %-20s %-30s %-15s%n",
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getEmail(),
                    cliente.getTelefono());
        }
        System.out.println("=========================================\n");
    }
}
