/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

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
               
                listaRetorno.add(pe);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
             System.out.println("======== Lista de Pedidos ===========");
        return listaRetorno;
    }
   
    }

