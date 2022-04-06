package InterfazGrafica;

import patronEstrategia.Servicio;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

public class Login extends Servicio implements Serializable {

    public String usuario;
    public String contrasenna;
    public String userlevel;

    public void ingresar() {

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = super.getConexion().createStatement();
            String sql = "SELECT userId, userPassword, userLevel FROM User WHERE userId = '" + usuario + "' ";
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                // si existe el usuario
                String tempID = rs.getString("userId");
                String tempPassword = rs.getNString("userPassword");
                String tempTipo = rs.getString("userLevel");

                if (contrasenna.equals(tempPassword)) {
                    // Verificar si es admin o cliente

                    if (tempTipo.equals("1")) {
                        JOptionPane.showMessageDialog(null, "Ingresó como admin");
                    } else if (tempTipo.equals("2")) {
                        JOptionPane.showMessageDialog(null, "Ingresó como cliente");
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");

                }
            } else {
                // si el usuario no existe

                JOptionPane.showMessageDialog(null, "El usuario no existe registrado");

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

        JOptionPane.showMessageDialog(null, "Bienvenido a la tienda en linea");
        usuario = JOptionPane.showInputDialog(null, "Digite su cédula");

    }

    public void digitarContrasena() {

        contrasenna = JOptionPane.showInputDialog(null, "Digite su contraseña");
    }

    public void validacionDatos() {

        digitarUsuario();
        digitarContrasena();
        try {
            ingresar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR");
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
