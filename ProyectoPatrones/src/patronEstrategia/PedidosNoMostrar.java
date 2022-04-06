/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patronEstrategia;

import java.util.List;

/**
 *
 * @author haziellopez
 */
public class PedidosNoMostrar implements ComportamientoPedidos{
    public List<Pedido> Pedidos()
    {
        System.out.println("No se muestran los pedidos hechos por los clientes");
        return null;
    }
}
