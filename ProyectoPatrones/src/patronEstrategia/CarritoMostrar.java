/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;
import java.util.List;
import patronDecorador.Carrito.*;

/**
 *
 * @author haziellopez
 */
public class CarritoMostrar implements ComportamientoCarrito{
   public void Carrito()
           
   {
       CarritoBase carrito = new CarritoBase();
       
                System.out.println("====== Carrito de Compras =======");
                for (Producto producto : carrito.BuscarProducto(0)) {
                    System.out.println(producto.getIdProducto() + " | " + producto.getNombre() + " | " + producto.getDescripcion() + " | " + producto.getPrecio());
   }
}
}