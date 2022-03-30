/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patronEstrategia;

import java.util.List;


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
       
               ServicioUsuario servicioUsuario = new ServicioUsuario();
        
         List<UsuarioTO> listado = servicioUsuario.demePersonas();
         for (UsuarioTO usuarioTO : listado) {
             System.out.println(usuarioTO.getUserName()+ " " + usuarioTO.getUserEmail());
         }
         System.out.println("====================================");
         UsuarioTO usuarioTORetorno = servicioUsuario.demePersona(2);
         System.out.println("La persona es : "+usuarioTORetorno.getUserName());
    }
    
}
