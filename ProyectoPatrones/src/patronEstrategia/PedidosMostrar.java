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
            String sql = "SELECT * FROM Pedidos";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pedido pe = new Pedido();
                pe.setNumPedido(rs.getInt("NumPedido"));
                pe.setIdUsuario(rs.getInt("idUsuario"));
                pe.setIdProducto(rs.getInt("idProducto"));
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

