package com.juanfedevmaster.farmacia;

import com.juanfedevmaster.farmacia.servicios.RegistroClientes;
import java.util.Optional;
import com.juanfedevmaster.farmacia.dominio.clientes.Cliente;

/**
 * Sistema de Farmacia - Programa principal
 * @author juanfe
 */
public class Farmacia {

    public static void main(String[] args) {
        System.out.println("========== SISTEMA DE FARMACIA ==========\n");

        // Crear el registro de clientes
        RegistroClientes registro = new RegistroClientes();

        // Demostración: Registrar clientes
        System.out.println(">>> REGISTRANDO CLIENTES <<<\n");
        registro.registrarCliente("Juan", "Pérez", "juan.perez@email.com", "123456789");
        registro.registrarCliente("María", "García", "maria.garcia@email.com", "987654321");
        registro.registrarCliente("Carlos", "López", "carlos.lopez@email.com", "555555555");
        registro.registrarCliente("Ana", "Martínez", "ana.martinez@email.com", "444444444");

        // Listar todos los clientes
        System.out.println("\n>>> LISTADO DE CLIENTES <<<");
        registro.listarClientes();

        // Buscar un cliente por ID
        System.out.println(">>> BUSCAR CLIENTE POR ID <<<");
        Optional<Cliente> cliente = registro.buscarPorId(1);
        if (cliente.isPresent()) {
            System.out.println("Encontrado: " + cliente.get());
        }

        // Buscar por email
        System.out.println("\n>>> BUSCAR CLIENTE POR EMAIL <<<");
        Optional<Cliente> clientePorEmail = registro.buscarPorEmail("maria.garcia@email.com");
        if (clientePorEmail.isPresent()) {
            System.out.println("Encontrado: " + clientePorEmail.get());
        }

        // Buscar por nombre
        System.out.println("\n>>> BUSCAR CLIENTES POR NOMBRE <<<");
        var resultados = registro.buscarPorNombre("ar");
        System.out.println("Clientes encontrados con 'ar' en el nombre:");
        resultados.forEach(c -> System.out.println("  - " + c.getNombreCompleto()));

        // Actualizar cliente
        System.out.println("\n>>> ACTUALIZAR CLIENTE <<<");
        registro.actualizarCliente(2, "María", "García López", "maria.garcia.nueva@email.com", "999999999");

        // Listar después de actualizar
        System.out.println("\n>>> LISTADO DESPUÉS DE ACTUALIZAR <<<");
        registro.listarClientes();

        // Información general
        System.out.println("Total de clientes registrados: " + registro.obtenerCantidadClientes());

        System.out.println("\n========== FIN DEL PROGRAMA ==========");
    }
}
