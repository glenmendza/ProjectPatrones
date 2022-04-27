/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronFabrica;
import InterfazGrafica.*;/**
 *
 * @author haziellopez
 */
public class CrearSneaker {
    Main log = new Main();
    private Cordones cordones;
    private Suelas suelas;
    private Plantillas plantillas;
    
    public CrearSneaker(TiendaVirtual tiendaVirtual)
    {
        cordones=tiendaVirtual.CrearCordones();
        suelas=tiendaVirtual.CrearSuelas();
        plantillas=tiendaVirtual.CrearPlantillas();
    }
    
    public void unirPartes()
    {
        cordones.agregar();
        suelas.poner();
        plantillas.colocar();
        log.menuCliente();
    }
}
