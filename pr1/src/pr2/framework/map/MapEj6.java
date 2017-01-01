/**
 * Clase que implementa la funci�n Map concreta para el ejercicio 6 de la pr�ctica
 */
package pr2.framework.map;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr2.Pareja;

/**
 * @author Javier Mart�n Moreno-Manzanaro
 *
 */
public class MapEj6 implements MapFunction {

	@Override
	public void map(Object clave, Object valor, ArrayList<Pareja> salida) {
		
		StringTokenizer tk = new StringTokenizer((String)valor, ",");
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		String superTemp = tk.nextToken();
		
		Float tempSuper = Float.parseFloat(superTemp);
		
		salida.add(new Pareja("minimo y m�ximo", tempSuper));
	}

}
