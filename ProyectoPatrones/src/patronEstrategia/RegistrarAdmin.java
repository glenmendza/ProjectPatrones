/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author haziellopez
 */
public class RegistrarAdmin extends Servicio implements ComportamientoRegistro {

    public void Registro() {
        System.out.println("Se registra un usuario administrador");
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
            String sql = "INSERT INTO User(userId, userName, userLastName, userEmail, userPassword, userLevel) VALUES(?,?,?,?,?,1);";
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, lastname);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, pass);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        } finally {
            cerrarPreparedStatement(preparedStatement);
            //closePreparedStatement(preparedStatement);
            //disconnect();
            desconectar();
            JOptionPane.showMessageDialog(null, "Se ha registrado a un usuario administrador con éxito con los siguientes datos.\n\nCédula: "+id+"\nNombre: "+name+"\nCorreo: "+email);
        }
    }

}
//            preparedStatement.setInt(1, registro.getUserId());
//            preparedStatement.setString(2, registro.getUserName());
//            preparedStatement.setString(3, registro.getUserLastName());
//            preparedStatement.setString(4, registro.getUserEmail());
//            preparedStatement.setString(5, registro.getUserPassword())