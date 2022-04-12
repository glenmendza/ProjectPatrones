/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronFabrica;

/**
 *
 * @author haziellopez
 */
public class SneakersNikeEL extends TiendaVirtual{
 public Cordones CrearCordones()
 {
     return new Poliester();
 }
 
 public Plantillas CrearPlantillas()
 {
     return new Acolchonadas();
 }
 
 public Suelas CrearSuelas()
 {
     return new Caucho();
 }
}
