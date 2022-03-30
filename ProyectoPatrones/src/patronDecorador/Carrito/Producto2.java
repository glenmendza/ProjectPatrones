
package patronDecorador.Carrito;


public class Producto2 {
    
    Carrito carrito;
    
    public Producto2(Carrito carrito){
        this.carrito = carrito;
    }
    
    public String getNombre(){
        return carrito.getNombre() + "327 Zipper New Balance";
    }
    
    public double getCosto(){
        return 80.0 + carrito.getCosto();
    }
    

    public int getCantidad(){
        return 1 + carrito.getCantidad();
    }
    
}
