
package Carrito;


public class Tester {

   
    public static void main(String[] args) {
        
        Carrito carrito = new CarritoBase();
  
        carrito.agregarProducto((Producto1) carrito);
        System.out.println(carrito.imprimirPedido());
    }
    
}
