/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

/**
 *
 * @author haziellopez
 */
public class UsuarioAdmin extends Usuario {
    public UsuarioAdmin() {
        comportamientoCarrito = new CarritoNoMostrar();
        comportamientoPedidos = new PedidosMostrar();
        comportamientoProductos = new ProductosModificar();
        comportamientoRegistro = new RegistrarAdmin();
    }

    public void display() {
        System.out.println("Este es un usuario de tipo administrador");
    }
}
