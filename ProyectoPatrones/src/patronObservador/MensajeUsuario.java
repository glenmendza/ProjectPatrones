/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronObservador;
public class MensajeUsuario implements Observador 
{
    @Override
    public void update(Mensaje m) {
        System.out.println("MessageSubscriberTwo :: " + m.getMessageContent());
    }
}
