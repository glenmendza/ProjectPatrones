
package patronDecorador.Carrito;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import patronEstrategia.*;


public abstract class Carrito extends Servicio{
    
public abstract List<Producto> BuscarProducto(int idProducto);
   
     
     
    
 
   
}
