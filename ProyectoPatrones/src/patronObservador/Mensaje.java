/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronObservador;

public class Mensaje 
{
    final String contenidoMensaje;
     
    public Mensaje (String m) {
        this.contenidoMensaje = m;
    }
 
    public String getMessageContent() {
        return contenidoMensaje;
    }
}
