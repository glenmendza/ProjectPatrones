package proyectopatrones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bernal
 */
public class Servicio {

    protected Connection connection = null;
    
//    private String host = "localhost";
//    private String puerto = "3306";
//    private String sid = "cciDemos";
    
    private String username = "admin";
    private String password = "adminadmin";
    private String connectionString = "jdbc:mysql:/patronesdb.ccakzl9duazr.us-east-1.rds.amazonaws.com:3306/patronesdb?zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
    
    public void conectar() {

        try {
            //Paso 1
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Paso 2
            connection = DriverManager.getConnection(connectionString, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeStatement(Statement statement) {
        try {
            if (statement != null && !statement.isClosed()) {
                statement.close();
                statement = null;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    public void closePreparedStatement(PreparedStatement preparedStatement) {
        try {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
                preparedStatement = null;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
        public void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null && !resultSet.isClosed()) {
                resultSet.close();
                resultSet = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                connection = null;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

