
package Carrito;

import java.util.ArrayList;


public abstract class Carrito {
    
    String nombre = "";
    double costo;
    int cantidad;
    
    ArrayList<Carrito> lstCarrito = new ArrayList<Carrito>();
    
     public void agregarProducto(Producto1 camisa) {
         this.lstCarrito.add(camisa);
}
     
     
     public String imprimirPedido() {
      for(Carrito carrito:this.lstCarrito){
          System.out.println(carrito.getNombre());
          System.out.println(carrito.getCosto());
          System.out.println(carrito.getCantidad());
          System.out.println("---------------------------------\n"
                  + "\n");
      }
      return "";
  }
    
    public String getNombre(){
        return nombre;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public int getCantidad(){
        return cantidad;
    }
   
}
