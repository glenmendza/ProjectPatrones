package patronDecorador.Carrito;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import patronEstrategia.Producto;

public class CarritoBase extends Carrito {

    static List<Producto> listaRetorno = new ArrayList<>();

    public List<Producto> BuscarProducto(int idProducto) {
        Statement stmt = null;
        ResultSet rs = null;

        try {

            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM Productos WHERE idProducto = " + idProducto;

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
