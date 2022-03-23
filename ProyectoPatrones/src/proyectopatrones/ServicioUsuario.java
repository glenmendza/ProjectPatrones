/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopatrones;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glenm
 */
public class ServicioUsuario extends Servicio{
    
    public List<UsuarioTO> demePersonas() {

        Statement stmt = null;
        ResultSet rs = null;
        List<UsuarioTO> listaRetorno = new ArrayList<>();

        try {
            connect();
            //Paso 3
            stmt = connection.createStatement();
            String sql = "SELECT userId, userName, userLastName, userEmail, userPassword, userLevel FROM User";
            //Paso 4
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("userId");
                String nom = rs.getString("userName");
                String apell = rs.getString("userLastName");
                String email = rs.getString("userEmail");
                String pass = rs.getString("userPassword");
                int level = rs.getInt("userLevel");
                UsuarioTO usuarioTO = new UsuarioTO(id, nom, apell, email, pass, level);
                listaRetorno.add(usuarioTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Paso 5
            closeResultSet(rs);
            closeStatement(stmt);
            disconnect();
        }
        return listaRetorno;
    }
    //Retorna UNA persona
    public UsuarioTO demePersona(int idPersona) {

        Statement stmt = null;
        ResultSet rs = null;
        UsuarioTO UsuarioTORetorno = null;

        try {
            connect();
            //Paso 3
            stmt = connection.createStatement();
            String sql = "SELECT userId, userName, userLastName, userEmail, userPassword, userLevel FROM User WHERE userId = " + idPersona;
            //Paso 4
            rs = stmt.executeQuery(sql);

            if (rs.next()) {
                int id = rs.getInt("userId");
                String nom = rs.getString("userName");
                String apell = rs.getString("userLastName");
                String email = rs.getString("userEmail");
                String pass = rs.getString("userPassword");
                int level = rs.getInt("userLevel");
                UsuarioTORetorno = new UsuarioTO(id, nom, apell, email, pass, level);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Paso 5
            closeResultSet(rs);
            closeStatement(stmt);
            disconnect();
        }
        return UsuarioTORetorno;
    }
    
    public void insert(UsuarioTO usuarioTO) {
            //*******
    }
    
}
