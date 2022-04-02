/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author haziellopez
 */
public class ProductosVer extends Servicio implements ComportamientoProductos {
  
      
       public List<Producto> Productos() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Producto> listaRetorno = new ArrayList<>();

        try {

            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM Productos";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt("idProducto"));
                p.setNombre(rs.getString("nombre"));
                p.setDescripcion(rs.getString("descripcion"));
                p.setPrecio(rs.getDouble("precio"));
                listaRetorno.add(p);
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
   
   
    }

