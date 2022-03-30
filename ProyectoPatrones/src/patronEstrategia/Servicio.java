package patronEstrategia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public abstract class Servicio {

    protected  Connection conexion = null;
//    private  String host = "jdbc:mysql:/patronesdb.ccakzl9duazr.us-east-1.rds.amazonaws.com:3306/patronesdb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
//    private  String puerto = "3306";
//    private  String sid = "PatronesDB";
//    private  String usuario = "admin";
//    private  String clave = "adminadmin";
    
    private String username = "admin";
    private String password = "adminadmin";
    private String connectionString = "jdbc:mysql://patronesdb.ccakzl9duazr.us-east-1.rds.amazonaws.com:3306/PatronesDB?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC"; 


    protected void conectar() {
        try {
            
            conexion = DriverManager.getConnection(connectionString, username, password);

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
    



