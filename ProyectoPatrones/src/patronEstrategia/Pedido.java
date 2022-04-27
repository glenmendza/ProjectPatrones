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
    private String userName;
    private String userLastName;
    private String nombre;
    private String descripcion;
    private double precio;
    private double monto;
//    SimpleDateFormat ft = 
//      new SimpleDateFormat ("dd.MM.yyyy");

    public Pedido() {
    }

    public Pedido(int idProducto, int numPedido, int idUsuario, String userName, String userLastName, String nombre, String descripcion, double precio, double monto) {
        this.idProducto = idProducto;
        this.numPedido = numPedido;
        this.idUsuario = idUsuario;
        this.userName = userName;
        this.userLastName = userLastName;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.monto = monto;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    
    
    
}
