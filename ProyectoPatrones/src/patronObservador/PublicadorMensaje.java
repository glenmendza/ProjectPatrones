/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronObservador;

import java.util.ArrayList;
import java.util.List;
 

//SUJETO CONCRETO
public class PublicadorMensaje implements Sujeto {
     
    private List<Observador> observadores = new ArrayList<>();
 
    @Override
    public void registrarObservador(Observador o) {
        observadores.add(o);
    }
 
    @Override
    public void removerObservador(Observador o) {
        observadores.remove(o);
    }
 
    @Override
    public void notificarObservadores(Mensaje m) {
        for(Observador o: observadores) {
            o.update(m);
        }
    }
} 

