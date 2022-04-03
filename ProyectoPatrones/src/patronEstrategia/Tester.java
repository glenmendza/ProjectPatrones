/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patronEstrategia;

import java.util.List;
import patronEstrategia.RegistrarAdmin;
        
        
public class Tester {

    public static void main(String[] args) {
        Usuario admin = new UsuarioAdmin();
        ProductosVer verProductos = new ProductosVer();
        ProductosModificar modificarProductos = new ProductosModificar();

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
        
        //RegistrarAdmin regadmin = new RegistrarAdmin();
        RegistroTO regto = new RegistroTO();
        //regadmin.insert(regto);
        
        RegistrarCliente regcliente = new RegistrarCliente();
        
        //registro de un nuevo cliente
        //regcliente.insert(regto);
        

        ServicioUsuario servicioUsuario = new ServicioUsuario();

        List<UsuarioTO> listado = servicioUsuario.demePersonas();
        for (UsuarioTO usuarioTO : listado) {
            System.out.println(usuarioTO.getUserName() + " " + usuarioTO.getUserEmail());
        }
        System.out.println("====================================");
        UsuarioTO usuarioTORetorno = servicioUsuario.demePersona(2);
        System.out.println("La persona es : " + usuarioTORetorno.getUserName());
        
      
     
       //Funciones Administrativas en la lista de productos
        modificarProductos.eliminarProducto(1);
       
           
        List<Producto> listadoP = verProductos.Productos();
        for (Producto producto : listadoP) {
            System.out.println(producto.getIdProducto() + " " + producto.getNombre()+" "+producto.getDescripcion()+" "+producto.getPrecio());
                   
        }
        Producto producto4 = new Producto();
        producto4.setIdProducto(4);
        producto4.setNombre("Top Mujer rojo");
        producto4.setDescripcion("Top para mujer marca adidas");
        producto4.setPrecio(39.99);
        
        modificarProductos.agregarProducto(producto4);
        
        for (Producto producto : listadoP) {
            System.out.println(producto.getIdProducto() + " " + producto.getNombre()+" "+producto.getDescripcion()+" "+producto.getPrecio());
                   
        }
        
     
        
    }

}
