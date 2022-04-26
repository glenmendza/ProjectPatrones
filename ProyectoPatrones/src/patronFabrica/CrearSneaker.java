/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronFabrica;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import patronEstrategia.Producto;

/**
 *
 * @author haziellopez
 */
public class CrearSneaker {
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
       
        
        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
         Scanner in3 = new Scanner(System.in);
     
        System.out.println("\tEscoja el material de sus cordones:\n 1)Nailon\n 2)Poliester ");
        materialCordones=in.nextInt();
        if(materialCordones==1){
            nailon.agregar();
        }else if(materialCordones==2){
        poliester.agregar();
    }
        System.out.println("\tEscoja el material de sus suelas:\n 1)Goma\n 2)Caucho ");
        materialSuelas=in2.nextInt();
         if(materialSuelas==1){
            goma.poner();
        }else if(materialSuelas==2){
        caucho.poner();
    }
        System.out.println("\tEscoja el material de sus plantillas:\n 1)Acolchonadas\n 2)Delgadas ");
        materialPlantillas=in3.nextInt();
 if(materialPlantillas==1){
           acolchonadas.colocar();
        }else if(materialPlantillas==2){
       delgadas.colocar();
    }

    }

    public int getMaterialCordones() {
        return materialCordones;
    }

    public void setMaterialCordones(int materialCordones) {
        this.materialCordones = materialCordones;
    }

    public int getMaterialSuelas() {
        return materialSuelas;
    }

    public void setMaterialSuelas(int materialSuelas) {
        this.materialSuelas = materialSuelas;
    }

    public int getMaterialPlantillas() {
        return materialPlantillas;
    }

    public void setMaterialPlantillas(int materialPlantillas) {
        this.materialPlantillas = materialPlantillas;
    }
    
    
}
