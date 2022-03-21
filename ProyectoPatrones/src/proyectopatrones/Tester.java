/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectopatrones;


public class Tester {

    public static void main(String[] args) {
       Usuario admin = new UsuarioAdmin();
       
       admin.display();
       
       admin.usarCarrito();
       admin.listaPedidos();
       admin.listaProductos();
       admin.realizarRegistro();
       
       Usuario cliente = new UsuarioCliente();
       
       cliente.display();
       
       cliente.usarCarrito();
       cliente.listaPedidos();
       cliente.listaProductos();
       cliente.realizarRegistro();
    }
    
}
