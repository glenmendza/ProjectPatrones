/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package patronEstrategia;

import java.util.List;
import patronEstrategia.RegistrarAdmin;
import javax.swing.*;
import patronObservador.*;
import InterfazGrafica.*;

public class Tester {

    public static void main(String[] args) {
        Usuario admin = new UsuarioAdmin();
        ProductosVer verProductos = new ProductosVer();
        ProductosModificar modificarProductos = new ProductosModificar();
        /*
        admin.display();

        admin.usarCarrito();
        admin.listaPedidos();
        admin.listaProductos();
        admin.realizarRegistro();

        Usuario cliente = new UsuarioCliente();

        cliente.display();

        cliente.usarCarrito();
        //cliente.listaPedidos();
        //cliente.listaProductos();
        cliente.realizarRegistro();
         */
        //RegistrarAdmin regadmin = new RegistrarAdmin();

        RegistroTO regto = new RegistroTO();
        //regadmin.insert(regto);

        RegistrarCliente regcliente = new RegistrarCliente();

        //registro de un nuevo cliente
        //regcliente.insert(regto);
        Login log = new Login();
        log.validacionDatos();

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
            System.out.println(producto.getIdProducto() + " " + producto.getNombre() + " " + producto.getDescripcion() + " " + producto.getPrecio());

        }

        Producto producto4 = new Producto();
        producto4.setIdProducto(4);
        producto4.setNombre("Top Mujer rojo");
        producto4.setDescripcion("Top para mujer marca adidas");
        producto4.setPrecio(39.99);

        modificarProductos.agregarProducto(producto4);

        for (Producto producto : listadoP) {
            //System.out.println(producto.getIdProducto() + " " + producto.getNombre()+" "+producto.getDescripcion()+" "+producto.getPrecio());
            JOptionPane.showMessageDialog(null, "ID producto: " + producto.getIdProducto() + "\n"
                    + "Nombre del producto: " + producto.getNombre() + "\n"
                    + "Descripcion del producto: " + producto.getDescripcion() + "\n"
                    + "Precio del producto: " + producto.getPrecio());

        }

        //Mostrar la lista de pedidos
        PedidosMostrar mostrarPedidos = new PedidosMostrar();
        List<Pedido> listadoPe = mostrarPedidos.Pedidos();
        for (Pedido pedido : listadoPe) {
            //System.out.println(pedido.getNumPedido() + " " + pedido.getIdUsuario() + " " + pedido.getIdProducto());
            JOptionPane.showMessageDialog(null, "ID pedido: " + pedido.getNumPedido() + "\n"
                    + "ID del usuario: " + pedido.getIdUsuario() + "\n"
                    + "ID del producto: " + pedido.getIdProducto());
        }

        MensajeAdmin ma = new MensajeAdmin();
        MensajeUsuario mu = new MensajeUsuario();
        PublicadorMensaje publicador = new PublicadorMensaje();

        publicador.registrarObservador(ma);

        int a = JOptionPane.showConfirmDialog(null, "Confirmar compra?");
        if (a == JOptionPane.YES_OPTION) {
            publicador.notificarObservadores(new Mensaje("Mensaje prueba"));

        } else {
            System.out.println("Se devuelve al carrito");
        }

    }

}
