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
public class Producto implements Serializable{
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    
    public Producto(){
        
    }
    
    public Producto(int idProducto,String nombre, String descripcion, double precio)
    {
        this.idProducto=idProducto;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
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

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
    
    
}
