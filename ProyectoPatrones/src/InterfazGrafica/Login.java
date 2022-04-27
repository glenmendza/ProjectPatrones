package InterfazGrafica;

import patronEstrategia.Servicio;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import patronEstrategia.*;
import patronDecorador.Carrito.*;
import patronObservador.*;
import patronFabrica.*;
import java.time.*;


//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Random;
//import java.sql.PreparedStatement;

public class Login extends Servicio implements Serializable,Observador {

    CarritoBase carrito = new CarritoBase();
    PedidosMostrar mostrarPedidos = new PedidosMostrar();
    List<Producto> listaCarrito = carrito.BuscarProducto(idProducto);
      SujetoConcreto sujeto = new SujetoConcreto();
        UsuarioTO observador = new UsuarioTO();
    ProductosModificar modificarProductos = new ProductosModificar();
    

    static int idProducto = 0;
    static int cantProducto = 0;
    public String usuario;
    public String contrasenna;
    public String userlevel;
    private SujetoConcreto Sujeto;
     private Pedido ultimaPosicion = mostrarPedidos.Pedidos().get(mostrarPedidos.Pedidos().size()-1);
    
    Pedido pedido = new Pedido();
    SujetoConcreto obs = new SujetoConcreto();
    
 
    
    
    public void ingresar() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = super.getConexion().createStatement();
            String sql = "SELECT userId, userPassword, userLevel FROM User WHERE userId = '" + usuario + "' ";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // si existe el usuario
                String tempID = rs.getString("userId");
                String tempPassword = rs.getNString("userPassword");
                String tempTipo = rs.getString("userLevel");

                if (contrasenna.equals(tempPassword)) {
                    // Verificar si es admin o cliente

                    if (tempTipo.equals("1")) {
                         
                        JOptionPane.showMessageDialog(null, "Bienvenido " + usuario + ". Ingresó como administrador! ", "7Shop", JOptionPane.INFORMATION_MESSAGE);
                        menuAdmin();
                    } else if (tempTipo.equals("2")) {
                        JOptionPane.showMessageDialog(null, "Bienvenido " + usuario + ". Ingresó como cliente! ", "7Shop", JOptionPane.INFORMATION_MESSAGE);
                        menuCliente();
                       
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta", "ERROR", JOptionPane.ERROR_MESSAGE);
                    inicio();

                }
            } else {
                // si el usuario no existe

                JOptionPane.showMessageDialog(null, "El usuario no está registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
                inicio();

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
    }

         public void actualizarEstado(){
        System.out.println("Se ha realizado un nuevo pedido por el usuario: " + ultimaPosicion);
        }
         
           //Al asignarsele un sujeto se va a actualizar el nombre de este
    public void sujetoAsignado(SujetoConcreto sujeto)
    {
        Sujeto = sujeto;
    }
    
    public void menuAdmin() {
        obs.Pedidos();
        obs.subirEstado("Actualizado");
   
    

        Scanner in = new Scanner(System.in);
        // Display del menu administrativo
        System.out.println("========= Menu Administrativo =========");
        
        System.out.println("1)\t Gestionar productos");
        System.out.println("2)\t Agregar usuario administrador");
        System.out.println("3)\t Gestionar pedidos");
        System.out.println("4)\t Cerrar sesión");
        System.out.println("5)\t Salir del sistema");
     

        System.out.println("Ingrese la opción que desea:");

        int opc = in.nextInt();

        switch (opc) {
            case 1:
                //menu admin productos

                gestionarProductos();
                break;
            case 2:
                RegistroTO regto = new RegistroTO();
                RegistrarAdmin registro = new RegistrarAdmin();
                registro.insert(regto);
                
                menuAdmin();
                break;
            case 3:
                
                gestionarPedidos();
                break;
            case 4:
                inicio();
            case 5:
                int resp = JOptionPane.showConfirmDialog(null, "Desea salir del sistema?", "7Shop", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                }
                if (resp == JOptionPane.NO_OPTION) {
                    menuAdmin();
                }
            default:
                System.out.println("Opción errónea");
                break;
        }//end of switch

    }//fin de metodo menu admin

    public void gestionarProductos() {
        //Declaracion de los scanners
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        Scanner in4 = new Scanner(System.in);

        List<Producto> listadoP = modificarProductos.Productos();
        System.out.println("====== Lista de Productos =======");
        for (Producto producto : listadoP) {
            System.out.println(producto.getIdProducto() + " | " + producto.getNombre() + " | " + producto.getDescripcion() + " | " + producto.getPrecio());
        }

        System.out.println("1)\t Eliminar un producto: ");
        System.out.println("2)\t Agregar un producto: ");
        System.out.println("3)\t Volver al menú: ");

        System.out.println("Ingrese la opción que desea:");

        int opc1 = in2.nextInt();
        switch (opc1) {
            case 1:
                try {
                    System.out.println("Digite el ID del producto que desea eliminar: ");
                    int id = in2.nextInt();
                    modificarProductos.eliminarProducto(id);

                   
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "7Shop", JOptionPane.ERROR_MESSAGE);
                } finally {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado  producto con éxito", "7Shop", JOptionPane.INFORMATION_MESSAGE);
                    gestionarProductos();
                }
                 break;
            case 2:
                Producto producto = new Producto();

                try {

                    Random rand = new Random();
                    int upperbound = 10000;

                    System.out.println("\t Nombre del producto: ");
                    String nombre = in3.nextLine();
                    producto.setNombre(nombre);

                    System.out.println("\t Descripción: ");
                    String descripcion = in4.nextLine();
                    producto.setDescripcion(descripcion);

                    System.out.println("\t Precio: ");
                    double precio = in2.nextDouble();
                    producto.setPrecio(precio);

                    producto.setIdProducto(rand.nextInt(upperbound));

                    modificarProductos.agregarProducto(producto);
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "7Shop", JOptionPane.ERROR_MESSAGE);
                } finally {
                    JOptionPane.showMessageDialog(null, "Se ha añadido un producto con éxito con los siguientes datos.\n\nID del producto: " + producto.getIdProducto() + "\nNombre del producto : " + producto.getNombre() + "\nDescripción: " + producto.getDescripcion() + "\nPrecio: " + producto.getPrecio(), "7Shop", JOptionPane.INFORMATION_MESSAGE);
                    gestionarProductos();
                }

            case 3:
                menuAdmin();
                break;

            default:
                System.out.println("Opción errónea");
                gestionarProductos();
        }

    }

    public Pedido getPedido() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = super.getConexion().createStatement();
            String sql = "SELECT Pedidos.NumPedido, User.userId, User.userName, User.userLastName, Pedidos.idProducto, Productos.nombre, Productos.descripcion, Productos.precio\n"
                    + "FROM Pedidos\n"
                    + "INNER JOIN User ON Pedidos.idUsuario = User.userId\n"
                    + "INNER JOIN Productos ON Pedidos.idProducto = Productos.idProducto\n"
                    + "WHERE Pedidos.idUsuario = ?;";

            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // si existe el usuario         
                pedido.setIdProducto(rs.getInt("idProducto"));
                pedido.setNumPedido(rs.getInt("NumPedido"));
                pedido.setIdUsuario(rs.getInt("idUsuario"));
                pedido.setMonto(rs.getDouble("monto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }

        return pedido;

    }

 

    public void gestionarPedidos() {
        Scanner in = new Scanner(System.in);
        PedidosMostrar mostrarPedidos = new PedidosMostrar();
        
        

// Display del menu para gestion de pedidos de admin
        System.out.println("========= Gestión de pedidos =========");
        sujeto.subirEstado("Nuevo pedido realizado");
        System.out.println("1)\t Ver lista de pedidos");
        System.out.println("2)\t Eliminar un pedido");
        System.out.println("3)\t Volver al menú");
       

        System.out.println("Ingrese la opción que desea:");

//        List<Pedido> listadoPe = mostrarPedidos.Pedidos();
//        for (Pedido pedido : listadoPe) {
//            System.out.println(pedido.getNumPedido() + " " + pedido.getIdUsuario() + " " + pedido.getIdProducto() + " " + pedido.getFecha());
//        }
        int opc = in.nextInt();
        switch (opc) {
            case 1:
               
                   List<Pedido> listadoPedido = mostrarPedidos.Pedidos();
        System.out.println("====== Lista de Pedidos =======");
         System.out.println("idPedido   idUsuario   idProducto    Costo");
        for (Pedido pedido : listadoPedido) {
            System.out.println(pedido.getNumPedido() + "       | " + pedido.getIdUsuario() + "         | " + pedido.getIdProducto() + "          | " + pedido.getMonto());
        }
                   gestionarPedidos();
         case 2:
           try {
                    System.out.println("Digite el ID del pedido que desea eliminar: ");
                    int id = in.nextInt();
                   mostrarPedidos.eliminarPedido(id);
                   
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "7Shop", JOptionPane.ERROR_MESSAGE);
                } finally {
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el pedido con éxito", "7Shop", JOptionPane.INFORMATION_MESSAGE);
                    
                }
           gestionarPedidos();
         break;

            case 3:
                inicio();
                break;
            default:
                System.out.println("Opción errónea");
                break;
            //end of switch

        }
        menuAdmin();
    }
//Menu principal de los clientes

    public void menuCliente() {

        
        Scanner in = new Scanner(System.in);
        ProductosVer verProductos = new ProductosVer();

// Display del menu para clientes
        System.out.println("========= Menu de Cliente =========");
        System.out.println("1)\t Ver lista de productos");
        System.out.println("2)\t Agregar un producto al carrito");
        System.out.println("3)\t Ver carrito de compras");
        System.out.println("4)\t Crear sneaker de la temporada");
        System.out.println("5)\t Crear sneaker edicion limitada");
        System.out.println("6)\t Salir del sistema");

        System.out.println("Ingrese la opción que desea:");

        int opc = in.nextInt();
        switch (opc) {
            case 1:

                List<Producto> listadoP = verProductos.Productos();
                System.out.println("====== Lista de Productos =======");
                for (Producto producto : listadoP) {
                    System.out.println(producto.getIdProducto() + " | " + producto.getNombre() + " | " + producto.getDescripcion() + " | " + producto.getPrecio());
                }
                menuCliente();
                break;

            case 2:

                System.out.println("Digite el id del producto que desea agregar: ");
                idProducto = in.nextInt();
                System.out.println("Digite la cantidad que desea agregar al carrito: ");
                cantProducto = in.nextInt();

                carrito.BuscarProducto(idProducto);
                System.out.println("Producto agregado al carrito");
                menuCliente();
                break;

            case 3:

                System.out.println("========= Carrito de compras =========");
                for (Producto productoC : listaCarrito) {
                    System.out.println(productoC.getIdProducto() + " | " + productoC.getNombre() + " | " + productoC.getDescripcion() + " | " + cantProducto + " | " + productoC.getPrecio()*cantProducto);
                }
                CarritoCompras();
                //menuCliente();
                break;

            case 4:
              
        TiendaVirtual sneakersNewBalance = new SneakersNewBalanceEL();
        CrearSneaker crear = new CrearSneaker(sneakersNewBalance);
                System.out.println("============= Sneakers de la temporada: Sneakers New Balance ===================");
        crear.unirPartes();
        
                
                break;
                
            case 5:
        TiendaVirtual sneakersNike = new SneakersNikeEL();
        CrearSneaker crear2 = new CrearSneaker(sneakersNike);
        System.out.println("============= Sneakers Nike Edicion Limitada ===================");
        crear2.unirPartes();

                break;
                case 6:
                 inicio();
                break;
            default:
                System.out.println("Opción errónea");
                break;
        }//end of switch

    }
    
    public void SeleccionSneakers(){
        Scanner in = new Scanner(System.in);
        System.out.println("Elija sus sneakers personalizados:\n 1)Sneakers New Balance Edicion Limitada\n 2) Sneakers Nike Edicion Limitada");
       int seleccion = in.nextInt();
        
         int opc = in.nextInt();
        switch (opc) {
            case 1:
       TiendaVirtual sneakersNewBalance = new SneakersNewBalanceEL();
        CrearSneaker crear = new CrearSneaker(sneakersNewBalance);
        crear.unirPartes();
        
                break;

            case 2:
 TiendaVirtual sneakersNike = new SneakersNikeEL();
        CrearSneaker crear2 = new CrearSneaker(sneakersNike);
        crear2.unirPartes();
         menuCliente();
         break;
            default:
                System.out.println("Opción errónea");
                break;
        }//end of switch
    }

    public boolean CarritoCompras() {
        boolean confirmacion=false;
        int input;
        
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
          Random rand = new Random();
                    int upperbound = 10000;
        System.out.println("1)\t Eliminar Producto");
        System.out.println("2)\t Completar Compra");
        System.out.println("3)\t Regresar");
        int opc2 = in.nextInt();
        switch (opc2) {
            case 1:
                System.out.println("Digite el id del producto en el carrito que desea eliminar: ");
                input=in2.nextInt();
                try{
                carrito.eliminarProductoCarrito(input);
                    System.out.println("Producto eliminado");
                } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "7Shop", JOptionPane.ERROR_MESSAGE);
        }
                CarritoCompras();
                break;

            case 2:
        //Aqui se hace la implementacion del patron observador        
               
        
                System.out.println("Monto total: "+montoTotal());
                System.out.println("Compra completada con exito!");
                
                        
                
              
                 agregarPedido();
                
      
               
                
                
                //Mensaje mensaje = new Mensaje(String m);
               
            //m = in.nextShort();
            //mensaje.getMessageContent();

            //sujetoConcreto.notificarObservadores(m);
            /*actualizar observador para que le envie notificacion al admin de que usuario x realizó
                        un nuevo pedido.
                        Además agregar los datos de los productos y id de usuario a la tabla pedidos
             */
            case 3:
                menuCliente();
                break;
            default:
                System.out.println("Opción errónea");
                break;
        }
        return confirmacion;
    }
    
    public void agregarPedido(){
        PreparedStatement preparedStatement = null;


        try {
            Random rand = new Random();
                    int upperbound = 10000;
                    
            conectar();
           
                   for (Producto productoC : listaCarrito) {
                    productoC.getIdProducto(); 
                            productoC.getPrecio() ;      
                
                  
                   
            String sql = "INSERT INTO Pedidos(NumPedido, idUsuario, idProducto,monto) VALUES(?,?,?,?);";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, rand.nextInt(upperbound));
            preparedStatement.setString(2, usuario);
            preparedStatement.setInt(3,productoC.getIdProducto());
            preparedStatement.setDouble(4,productoC.getPrecio()*cantProducto);
            preparedStatement.executeUpdate();
        }
             
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "7Shop", JOptionPane.ERROR_MESSAGE);
        } finally {
            cerrarPreparedStatement(preparedStatement);
            desconectar();
        }
        listaCarrito.clear();//va a vaciar el carrito cuando se complete la compra
        menuCliente(); 
    }

    public double montoTotal(){
        double suma=0.0;
       CarritoBase basePrecio = new CarritoBase();
        for (Producto productoC : listaCarrito)  {            
        suma+=basePrecio.costo()+ productoC.getPrecio()*cantProducto;  
        }
        return suma;
    }
    
    public void inicio() {
        String[] opciones = {"Ingresar", "Registrar"};

        int x = JOptionPane.showOptionDialog(null, "Bienvenido a la tienda en línea",
                "7Shop",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        if (x == 1) {

            RegistroTO regto = new RegistroTO();
            RegistrarCliente registro = new RegistrarCliente();
            registro.insert(regto);
            inicio();

            //registrarUsuario();
        } else if (x == 0) {
            validacionDatos();
        } else {
            int resp = JOptionPane.showConfirmDialog(null, "No seleccionaste ninguna opción\n\nDesea salir del sistema?", "7Shop", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                System.out.println("Ninguna opción seleccionada, saliendo del sistema...");
                System.exit(0);
            }
            if (resp == JOptionPane.NO_OPTION) {
                inicio();
            }

        }

    }

    public void digitarUsuario() {
        usuario = JOptionPane.showInputDialog(null, "Digíte su cédula", "7Shop", JOptionPane.INFORMATION_MESSAGE);
    }

    public void digitarContrasena() {
        contrasenna = JOptionPane.showInputDialog(null, "Digíte su contraseña", "7Shop", JOptionPane.INFORMATION_MESSAGE);
    }

    public void validacionDatos() {

        digitarUsuario();
        digitarContrasena();
        try {
            ingresar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "7Shop", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

}
