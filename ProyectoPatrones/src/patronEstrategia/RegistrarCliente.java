package patronEstrategia;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class RegistrarCliente extends Servicio implements ComportamientoRegistro {

    public void Registro() {
        System.out.println("Se registra un usuario cliente");
    }

    public void insert(RegistroTO registro) {
        PreparedStatement preparedStatement = null;

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su cédula", "7Shop", JOptionPane.INFORMATION_MESSAGE));
        String name = JOptionPane.showInputDialog(null, "Ingrese su nombre", "7Shop", JOptionPane.INFORMATION_MESSAGE);
        String lastname = JOptionPane.showInputDialog(null, "Ingrese su apellido", "7Shop", JOptionPane.INFORMATION_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Ingrese su email", "7Shop", JOptionPane.INFORMATION_MESSAGE);
        String pass = JOptionPane.showInputDialog(null, "Ingrese su contraseña", "7Shop", JOptionPane.INFORMATION_MESSAGE);

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
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "7Shop", JOptionPane.ERROR_MESSAGE);
        } finally {
            cerrarPreparedStatement(preparedStatement);
            desconectar();
             JOptionPane.showMessageDialog(null, "Tu registro se ha completado con éxito.\nAhora puedes ingresar sesión con los siguientes datos\n\nID: " + id + "\nContraseña : " + pass, "7Shop", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
