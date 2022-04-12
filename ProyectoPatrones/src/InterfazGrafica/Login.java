package InterfazGrafica;

import patronEstrategia.Servicio;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.*;
import java.util.Scanner;
import patronEstrategia.*;
import java.util.Random;


public class Login extends Servicio implements Serializable {

    public String usuario;
    public String contrasenna;
    public String userlevel;
    ProductosModificar modificarProductos = new ProductosModificar();

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
                        menuAdmin();
                    } else if (tempTipo.equals("2")) {
                        menuCliente();
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");

                }
            } else {
                // si el usuario no existe

                JOptionPane.showMessageDialog(null, "El usuario no está registrado");

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
    }
    
    public void registrarUsuario()
    {
       PreparedStatement preparedStatement = null;
        
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su ID"));
        String name = JOptionPane.showInputDialog(null,"Ingrese su nombre");
        String lastname = JOptionPane.showInputDialog(null,"Ingrese su apellido");
        String email = JOptionPane.showInputDialog(null,"Ingrese su email");
        String pass = JOptionPane.showInputDialog(null,"Ingrese su contraseña");
        
        
        try {
            conectar();
            String sql = "INSERT INTO User(userId, userName, userLastName, userEmail, userPassword, userLevel) VALUES(?,?,?,?,?,2);";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastname);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, pass);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarPreparedStatement(preparedStatement);
            //closePreparedStatement(preparedStatement);
            //disconnect();
            desconectar();
        }
        
        inicio();
    }
    
    public void menuAdmin()
    {
        Scanner in = new Scanner(System.in);
        // Display del menu administrativo
         System.out.println("========= Menu Administrativo =========");
        System.out.println("1)\t Gestionar Productos");
        System.out.println("2)\t Agregar usuario administrador");
        System.out.println("3)\t Gestionar Pedidos");
         System.out.println("4)\t Salir del sistema");
        
       
        System.out.println("Ingrese la opcion que desea:");
        
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
                break;
            default:
                System.out.println("Opcion erronea");
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
            System.out.println(producto.getIdProducto() + " " + producto.getNombre() + " " + producto.getDescripcion() + " " + producto.getPrecio());
              }
        
        System.out.println("1)\t Eliminar un producto: ");
        System.out.println("2)\t Agregar un producto: ");
        System.out.println("3)\t Volver: ");
        
        System.out.println("Ingrese la opcion que desea:");
        
        int opc1 = in2.nextInt();
               switch(opc1){
                   case 1:
                       
                        System.out.println("Digite el id del producto que desea eliminar: ");
                        int id = in2.nextInt();
                       modificarProductos.eliminarProducto(id);
                       System.out.println("Producto eliminado");
                       gestionarProductos();
                       break;
                   case 2:
                       Producto producto = new Producto();
                       
                       
                       Random rand = new Random();
                       int upperbound = 10000;
                       
                       
                       
                       
                       
                       System.out.println("\t Nombre del producto: ");
                       String nombre=in3.nextLine();
                       producto.setNombre(nombre);
                      
                       System.out.println("\t Descripcion: "); 
                       String descripcion=in4.nextLine();
                       producto.setDescripcion(descripcion);
                       
                       System.out.println("\t Precio: ");    
                       double precio=in2.nextDouble();
                       producto.setPrecio(precio);
                       
                       producto.setIdProducto(rand.nextInt(upperbound));
                       
                       
                       modificarProductos.agregarProducto(producto);
                       System.out.println("Producto agregado");
                       gestionarProductos();
                       break;
                       
                   case 3:
                       menuAdmin();
                       break;
                       
                        default:
                System.out.println("Opcion erronea");
                gestionarProductos();
               }
                
            
    }

    public void gestionarPedidos(){
      PedidosMostrar mostrarPedidos = new PedidosMostrar();
      mostrarPedidos.Pedidos();
      
      List<Pedido> listadoPe = mostrarPedidos.Pedidos();
        for (Pedido pedido : listadoPe) {
            System.out.println(pedido.getNumPedido() + " " + pedido.getIdUsuario() + " " + pedido.getIdProducto());
    }
        menuAdmin();
    }
   
//Menu principal de los clientes
public void menuCliente() {

    Scanner in = new Scanner(System.in);
ProductosVer verProductos = new ProductosVer();        

// Display del menu para clientes
         System.out.println("========= Menu de Cliente =========");
        System.out.println("1)\t Ver Lista de productos");
        System.out.println("2)\t Ver carrito de compras");
         System.out.println("3)\t Salir del sistema");
        
       
        System.out.println("Ingrese la opcion que desea:");
        
         int opc = in.nextInt();       
        switch (opc) {
            case 1:
      
          List<Producto> listadoP = verProductos.Productos();
                System.out.println("====== Lista de Productos =======");
        for (Producto producto : listadoP) {
            System.out.println(producto.getIdProducto() + " " + producto.getNombre() + " " + producto.getDescripcion() + " " + producto.getPrecio());
              }
        menuCliente();
        break;
        
        case 2:
     CarritoMostrar mostrarCarrito = new CarritoMostrar();
     mostrarCarrito.Carrito();
     menuCliente();
                break;
            case 3:
                 inicio();
                 break;
            default:
                System.out.println("Opcion erronea");
                break;
        }//end of switch
         
    }

    public void inicio(){
        String[] opciones = {"Ingresar", "Registrar"};
        
        int x = JOptionPane.showOptionDialog(null, "Bienvenido a la tienda en linea",
                "Bienvenido",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
        if(x==1)
        {
         registrarUsuario();   
        }else if(x==0)
        {
            validacionDatos();
        }else{
            System.out.println("Ninguna opcion seleccionada");
            
        }
        

    }
    public void digitarUsuario() {

       
        usuario = JOptionPane.showInputDialog(null, "Digite su cédula");

    }

    public void digitarContrasena() {

        contrasenna = JOptionPane.showInputDialog(null, "Digite su contraseña");
    }

    public void validacionDatos() {
        
        digitarUsuario();
        digitarContrasena();
        try {
            ingresar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
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
