package proyectopatrones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public abstract class Servicio {

    private  Connection conexion = null;
    private  String host = "jdbc:mysql:/patronesdb.ccakzl9duazr.us-east-1.rds.amazonaws.com:3306/patronesdb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    private  String puerto = "3306";
    private  String sid = "PatronesDB";
    private  String usuario = "admin";
    private  String clave = "adminadmin";


    protected void conectar() {
        try {
            
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + sid + "?serverTimezone=UTC" ,usuario, clave);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected Connection getConexion() {
        try {
            if (this.conexion != null && this.conexion.isClosed()) {
                return this.conexion;
            } else {
                this.conectar();

            }
        } catch (Exception e) {

        }
        return this.conexion;
    }

    protected void cerrarStatement(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
protected void cerrarPreparedStatement(PreparedStatement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
                stmt = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void cerrarResultSet(ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
                rs = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                conexion = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    



