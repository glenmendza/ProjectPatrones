/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

import patronObservador.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haziellopez
 */
public class UsuarioCliente extends Usuario {
    
private String nombreUsuario;
private List<UsuarioAdmin> administradores = new ArrayList<>();//En esta lista se van a almacenar los observadores, o sea la lista de administradores que van a recibir la notificacion
    public UsuarioCliente() {
        comportamientoCarrito = new CarritoMostrar();
        comportamientoPedidos = new PedidosNoMostrar();
        comportamientoProductos = new ProductosVer();
        comportamientoRegistro = new RegistrarCliente();
       
    }

  
    
    
}
