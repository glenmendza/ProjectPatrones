/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import patronObservador.*;

/**
 *
 * @author haziellopez
 */
public class UsuarioAdmin extends Usuario{
    
    private UsuarioCliente cliente = new UsuarioCliente();
    
    
    
    public UsuarioAdmin() {
        comportamientoCarrito = new CarritoNoMostrar();
        comportamientoPedidos = new PedidosMostrar();
        comportamientoProductos = new ProductosModificar();
        comportamientoRegistro = new RegistrarAdmin();
    }
    

    
  
}
