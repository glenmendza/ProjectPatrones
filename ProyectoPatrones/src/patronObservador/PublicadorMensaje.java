/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronObservador;

import java.util.ArrayList;
import java.util.List;
 

//SUJETO CONCRETO
public class PublicadorMensaje implements Sujeto {
    private ArrayList observadores;
    private String notificacion;
    
    public PublicadorMensaje()
            {
                observadores = new ArrayList();
            }
 
    
    public void registrarObservador(Observador o) {
        observadores.add(o);
    }
 
   
    public void removerObservador(Observador o) {
        int i = observadores.indexOf(o);
        if(i >= 0)
        {
            observadores.remove(o);
        }
    }
 
   
    public void notificarObservadores() {
        for(int i =0;i<observadores.size();i++) {
            Observador observador = (Observador)observadores.get(i);
            
            observador.update(notificacion);
        }
    }
    
    public void estadosCambiados(){
        notificarObservadores();
    }
    
    public void setEstados(String notificacion)
    {
        this.notificacion=notificacion;
        estadosCambiados();
    }
} 

