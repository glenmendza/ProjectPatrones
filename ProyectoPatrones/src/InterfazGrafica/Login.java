
package InterfazGrafica;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import proyectopatrones.*;

public class Login extends Servicio implements Serializable   {
    
    
    
    
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
                String tempPassword = rs.getNString("userName");
                String tempID = rs.getString("userId");
                String tempTipo = rs.getString("userLevel");

                if (usuario.equals(tempID) && contrasenna.equals(tempPassword) && tempTipo.equals("2")) {
                    JOptionPane.showMessageDialog(null, "Se ingreso al sistema");
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cerrarResultSet(rs);
            cerrarStatement(stmt);
            desconectar();
        }
    }
    
    
    public void digitarUsuario(){
        
      JOptionPane.showMessageDialog(null,"Hello, Welcome to Javatpoint.");   
      usuario = JOptionPane.showInputDialog(null,"Usuario");
      
   
    }
    
     public void digitarContrasena(){
        
        contrasenna = JOptionPane.showInputDialog(null,"Contrasena");
    }
     
    public void validacionDatos(){
        digitarUsuario();
        digitarContrasena();
        ingresar();
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
