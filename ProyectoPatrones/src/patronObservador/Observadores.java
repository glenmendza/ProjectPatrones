
package patronObservador;


public class Observadores{
       private String nombre;
       private SujetoConcreto Sujeto;
       
       public void update(){
          System.out.println("Se ha realizado un pedido y se ha notificado al administrador");
       }


   
}
