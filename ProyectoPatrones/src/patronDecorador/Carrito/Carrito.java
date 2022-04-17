
package patronDecorador.Carrito;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import patronEstrategia.*;


public abstract class Carrito extends Servicio{
String precio; 
public abstract List<Producto> BuscarProducto(int idProducto);  
public abstract double costo();
}
