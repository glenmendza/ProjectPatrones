/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

/**
 *
 * @author haziellopez
 */
public class UsuarioCliente extends Usuario {

    public UsuarioCliente() {
        comportamientoCarrito = new CarritoMostrar();
        comportamientoPedidos = new PedidosNoMostrar();
        comportamientoProductos = new ProductosVer();
        comportamientoRegistro = new RegistrarCliente();
    }

    public void display() {
        System.out.println("Este es un usuario de tipo cliente");
    }
}
