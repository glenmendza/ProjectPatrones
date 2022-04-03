/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

import java.io.Serializable;

/**
 *
 * @author haziellopez
 */
public class Pedido implements Serializable{
    private int idProducto;
    private int numPedido;
    private int idUsuario;
    
    
    public Pedido(){
        
    }
    
    public Pedido(int idProducto,int numPedido, int idUsuario)
    {
        this.idProducto=idProducto;
        this.numPedido = numPedido;
        this.idUsuario = idUsuario;
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

   
    
}
