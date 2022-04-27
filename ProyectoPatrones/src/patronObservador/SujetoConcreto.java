/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronObservador;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import patronEstrategia.*;

/**
 *
 * @author hazie
 */
public class SujetoConcreto extends Servicio{
     
    private List<ObservadoresTO> listaRetorno = new ArrayList<>();
    private List<Pedido> listaPedidos = new ArrayList<>();
    private PedidosMostrar mostrarPedidos = new PedidosMostrar();
    private String titulo;
    
    Observadores observadores = new Observadores();
    
     //Este es el metodo equivalente a asignar un observador. Todos los admin son observadores.
    public List<ObservadoresTO> Observadores() {
        Statement stmt = null;
        ResultSet rs = null;
       

        try {

            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM User WHERE userLevel = " + 1;

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ObservadoresTO o = new ObservadoresTO();
                o.setUserId(rs.getInt("userId"));
                o.setUserName(rs.getString("userName"));
                o.setUserLastName(rs.getString("userLastName"));
                o.setUserEmail(rs.getString("userEmail"));
                o.setUserPassword(rs.getString("userPassword"));
                o.setUserLevel(rs.getInt("userLevel"));
                listaRetorno.add(o);
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
 
    public List<Pedido> Pedidos() {
        Statement stmt = null;
        ResultSet rs = null;
       

        try {

            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM Pedidos ";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Pedido p = new Pedido();
                p.setNumPedido(rs.getInt("NumPedido"));
                p.setIdUsuario(rs.getInt("idUsuario"));
                p.setIdProducto(rs.getInt("idProducto"));
                p.setMonto(rs.getDouble("monto"));
                listaPedidos.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
        return listaPedidos;
    }
    
 

    public void notificarObservadores(){
   for(ObservadoresTO observadores : listaRetorno)
   {
        this.observadores.update();
                
   }
}
 
    public void subirEstado(String titulo){
        this.titulo=titulo;
       notificarObservadores();
    }

 
    
}
