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
    boolean bandera = false;

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
                    //bandera=true;
                    break;
                    
                }
                if (usuario.equals(tempID) && contrasenna.equals(tempPassword) && tempTipo.equals("2")){
                        
                JOptionPane.showMessageDialog(null, "Se ingreso al sistema como Usuario2 (Cliente)");
                //bandera=true;
                break;
                
                
                }else{
                    
                
                JOptionPane.showMessageDialog(null, "Sus datos no son validos. Registrese o intentelo de nuevo");
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

    public void digitarUsuario() {

        JOptionPane.showMessageDialog(null, "Bienvenido a la tienda en linea ");
        usuario = JOptionPane.showInputDialog(null, "Usuario");

    }

    public void digitarContrasena() {

        contrasenna = JOptionPane.showInputDialog(null, "Contrasena");
    }

    public void validacionDatos() {
      // do {
           
       
         
        digitarUsuario();
        digitarContrasena();
       
      
        
        try {
            ingresar();
              //while(bandera =! true);
        
        
      
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
