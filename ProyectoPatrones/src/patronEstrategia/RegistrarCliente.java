
package patronEstrategia;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class RegistrarCliente extends Servicio implements ComportamientoRegistro{
     public void Registro() {
        System.out.println("Se registra un usuario cliente");
    }

    public void insert(RegistroTO registro) {
        PreparedStatement preparedStatement = null;
        
        int id = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese su ID"));
        String name = JOptionPane.showInputDialog(null,"Ingrese su nombre");
        String lastname = JOptionPane.showInputDialog(null,"Ingrese su apellido");
        String email = JOptionPane.showInputDialog(null,"Ingrese su email");
        String pass = JOptionPane.showInputDialog(null,"Ingrese su contraseña");
        
        
        try {
            conectar();
            String sql = "INSERT INTO User(userId, userName, userLastName, userEmail, userPassword, userLevel) VALUES(?,?,?,?,?,2);";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastname);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, pass);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarPreparedStatement(preparedStatement);
            //closePreparedStatement(preparedStatement);
            //disconnect();
            desconectar();
        }
    }

}
