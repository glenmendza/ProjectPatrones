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
import java.util.Scanner;

/**
 *
 * @author haziellopez
 */
public class ProductosModificar extends Servicio implements ComportamientoProductos{
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
    
    public void agregarProducto(Producto producto) {//agrega un nuevo producto a la bd       
        PreparedStatement st = null;
        try {
            this.conectar();

            st = this.getConexion().prepareStatement("INSERT IGNORE INTO Productos (idProducto,nombre,descripcion,precio) VALUES (?,?,?,?)");
            st.setInt(1,producto.getIdProducto());
            st.setString(2, producto.getNombre());
            st.setString(3, producto.getDescripcion());
            st.setDouble(4, producto.getPrecio());

            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            cerrarPreparedStatement(st);
            desconectar();
        }

    }
    
    public void eliminarProducto(int id){
         
        
       
          PreparedStatement st = null;
        try {
            this.conectar();
            st = this.getConexion().prepareStatement("DELETE FROM Productos WHERE idProducto = ?");
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