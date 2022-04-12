/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronFabrica;

/**
 *
 * @author haziellopez
 */
public class SneakersNewBalanceEL extends TiendaVirtual{
    public Cordones CrearCordones()
 {
     return new Nailon();
 }
 
 public Plantillas CrearPlantillas()
 {
     return new Delgadas();
 }
 
 public Suelas CrearSuelas()
 {
     return new Goma();
 }
}
