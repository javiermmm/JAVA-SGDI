/**
 * Clase que implementa la función Map concreta para el ejercicio 4 de la práctica
 */
package pr2.framework.map;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class MapEj4 implements MapFunction {

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
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		String sensacionTermica = tk.nextToken();
		
		if (! superTemp.equals(sensacionTermica))
			salida.add(new Pareja(String.valueOf(clave), valor));
	}

}
