/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patronFabrica;

import java.util.Scanner;

public class SneakerBase extends TiendaVirtual {

    TiendaVirtual tienda = new SneakerBase();
    CrearSneaker sneaker = new CrearSneaker(tienda);
    Scanner in = new Scanner(System.in);
    Scanner in2 = new Scanner(System.in);
    Scanner in3 = new Scanner(System.in);
    int materialCordones;
    int materialSuelas;
    int materialPlantillas;
    Nailon nailon = new Nailon();
    Poliester poliester = new Poliester();
    Acolchonadas acolchonadas = new Acolchonadas();
    Delgadas delgadas = new Delgadas();
    Goma goma = new Goma();
    Caucho caucho = new Caucho();

    public Cordones CrearCordones() {
        System.out.println("\tEscoja el material de sus cordones:\n 1)Nailon\n 2)Poliester ");
        materialCordones = in.nextInt();
        if (materialCordones == 1) {
            nailon.agregar();
        } else if (materialCordones == 2) {
            poliester.agregar();
            
        }else{
            System.out.println("Opcion invalida");
           
        }
        return null;

    }

    public Suelas CrearSuelas() {

    }

    public Plantillas CrearPlantillas() {

    }

}
