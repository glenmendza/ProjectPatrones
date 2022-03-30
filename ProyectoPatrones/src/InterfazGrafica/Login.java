package InterfazGrafica;

import patronEstrategia.Servicio;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Login extends Servicio implements Serializable {

    public String usuario;
    public String contrasenna;
    public int tempIDuser;

    public int getTempIDuser() {
        return tempIDuser;
    }

    public void setTempIDuser(int tempIDuser) {
        this.tempIDuser = tempIDuser;
    }

    public void ingresar() {

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = super.getConexion().createStatement();
            String sql = "SELECT * FROM User";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String tempPassword = rs.getNString("userPassword");
                String tempID = rs.getString("userId");
                String tempTipo = rs.getString("userLevel");

                if (usuario.equals(tempID) && contrasenna.equals(tempPassword) && tempTipo.equals("1")) {
                    JOptionPane.showMessageDialog(null, "Se ingreso al sistema como Usuario1 (Admin)");
                    break;
                }
                JOptionPane.showMessageDialog(null, "Se ingreso al sistema como Usuario2 (Cliente)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
    }

    public void digitarUsuario() {

        JOptionPane.showMessageDialog(null, "Hello, Welcome to Centroamerica.");
        usuario = JOptionPane.showInputDialog(null, "Usuario");

    }

    public void digitarContrasena() {

        contrasenna = JOptionPane.showInputDialog(null, "Contrasena");
    }

    public void validacionDatos() {
        digitarUsuario();
        digitarContrasena();

        try {
            ingresar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN INGRESAR");
            e.printStackTrace();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

}
