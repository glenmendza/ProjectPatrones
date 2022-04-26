/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;
import java.time.*; 
import java.io.Serializable;
import java.util.*;
import java.text.*;

/**
 *
 * @author haziellopez
 */
public class Pedido implements Serializable{
    private int idProducto;
    private int numPedido;
    private int idUsuario;
    private double monto;
//    SimpleDateFormat ft = 
//      new SimpleDateFormat ("dd.MM.yyyy");
    
    
    public Pedido(){
     
    }
    
    public Pedido(int idProducto,int numPedido, int idUsuario,double monto)
    {
        this.idProducto=idProducto;
        this.numPedido = numPedido;
        this.idUsuario = idUsuario;
        this.monto=monto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
  public void actualizarEstado(){
    System.out.println("Se ha realizado un nuevo pedido por el usuario: " + idUsuario);
    }
    
    
   
    
}
