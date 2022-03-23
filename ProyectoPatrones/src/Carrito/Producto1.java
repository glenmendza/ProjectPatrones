
package Carrito;


public class Producto1 extends Decorador{
    
    Carrito carrito;
    
    public Producto1(Carrito carrito){
        this.carrito = carrito;
    }
    
    public String getNombre(){
        return "Chuck Taylor All Star Move";
    }
    
    public double getCosto(){
        return 50.0 + carrito.getCosto();
    }
    

    public int getCantidad(){
        return 1 + carrito.getCantidad();
     }
    
}
