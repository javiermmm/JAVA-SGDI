/**
 * Clase que implementa la función Map concreta para el ejercicio 6 de la práctica
 */
package pr2.framework.map;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
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
		
		salida.add(new Pareja("minimo y máximo", tempSuper));
	}

}
