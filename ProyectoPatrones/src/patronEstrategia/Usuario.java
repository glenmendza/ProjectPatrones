
package patronEstrategia;


public abstract class Usuario {
    ComportamientoCarrito comportamientoCarrito;
    ComportamientoPedidos comportamientoPedidos;
    ComportamientoProductos comportamientoProductos;
    ComportamientoRegistro comportamientoRegistro;
    
    public Usuario()
    {
        
    }
    
    public void setComportamientoCarrito(ComportamientoCarrito cc)
    {
        comportamientoCarrito = cc;
    }
    
    public void setComportamientoPedidos (ComportamientoPedidos cpe)
    {
        comportamientoPedidos = cpe;
    }
    
    public void setComportamientoProductos (ComportamientoProductos cpr)
    {
        comportamientoProductos = cpr;
    }
    
    public void setComportamientoRegistro (ComportamientoRegistro cr)
    {
        comportamientoRegistro = cr;
    }
    
    public void usarCarrito(){
        comportamientoCarrito.Carrito();
    }
    
    public void listaPedidos(){
        comportamientoPedidos.Pedidos();
    }
    
    public void listaProductos(){
        comportamientoProductos.Productos();
    }
    
    public void realizarRegistro(){
        comportamientoRegistro.Registro();
    }
    
    public abstract void display();
}
