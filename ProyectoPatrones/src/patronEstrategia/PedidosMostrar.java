/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PedidosMostrar extends Servicio implements ComportamientoPedidos{
   
         public List<Pedido> Pedidos() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Pedido> listaRetorno = new ArrayList<>();

        try {

            stmt = super.getConexion().createStatement();
            String sql = "SELECT Pedidos.NumPedido, User.userId, User.userName, User.userLastName, Pedidos.idProducto, Productos.nombre, Productos.descripcion, Productos.precio, Pedidos.idUsuario, Pedidos.monto\n" +
                         "FROM Pedidos\n" +
                         "INNER JOIN User ON Pedidos.idUsuario = User.userId\n" +
                         "INNER JOIN Productos ON Pedidos.idProducto = Productos.idProducto;";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pedido pe = new Pedido();
                pe.setNumPedido(rs.getInt("NumPedido"));
                pe.setIdUsuario(rs.getInt("userId"));
                pe.setUserName(rs.getString("userName"));
                pe.setUserLastName(rs.getString("userLastName"));
                pe.setIdProducto(rs.getInt("idProducto"));
                pe.setNombre(rs.getString("nombre"));
                pe.setDescripcion(rs.getString("descripcion"));
                pe.setIdUsuario(rs.getInt("idUsuario"));
                pe.setPrecio(rs.getDouble("precio"));
                pe.setMonto(rs.getDouble("monto"));
                
                listaRetorno.add(pe);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
             
        return listaRetorno;
    }
         
         public void eliminarPedido(int id){      
          PreparedStatement st = null;
        try {
            this.conectar();
            st = this.getConexion().prepareStatement("DELETE FROM Pedidos WHERE NumPedido = ?");
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarPreparedStatement(st);
            desconectar();
        }
        
       
    }
   
    }

