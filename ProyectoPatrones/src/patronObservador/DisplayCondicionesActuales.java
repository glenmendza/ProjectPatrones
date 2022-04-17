/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronObservador;

//Observador Concreto
public class DisplayCondicionesActuales implements Observador,ElementoDespliegue
{
    private String notificacion;
    private Sujeto PublicadorMensaje;
    
    public DisplayCondicionesActuales(Sujeto PublicadorMensaje){
        this.PublicadorMensaje=PublicadorMensaje;
        PublicadorMensaje.registrarObservador(this);
    }
    
    public void update(String notificacion){
        this.notificacion=notificacion;
        desplegar();
    }
    public void desplegar(){
    System.out.println("Pedidos recientes: "+notificacion);
    }
}
