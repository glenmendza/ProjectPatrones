
package patronObservador;
import InterfazGrafica.*;
import patronEstrategia.*;


public class ObservadoresTO {
    private int userId;
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
    private int userLevel;
    private SujetoConcreto Sujeto;
    private Pedido pedido;
    
    Login log = new Login();
      

    public ObservadoresTO(int userId, String userName, String userLastName, String userEmail, String userPassword, int userLevel) {
        this.userId = userId;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userLevel = userLevel;
    }
   public ObservadoresTO(){
       
   }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }
    
    public void actualizarEstado(){
        System.out.println("Se ha realizado un nuevo pedido por el usuario: " + userId);
    }
    
    
    //Al asignarsele un sujeto se va a actualizar el nombre de este
    public void sujetoAsignado(SujetoConcreto sujeto)
    {
        Sujeto = sujeto;
    }
    
    
    
    
}
