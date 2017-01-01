/**
 * Clase que implementa la funci�n Map concreta para el ejercicio 4 de la pr�ctica
 */
package pr2.framework.map;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr2.Pareja;

/**
 * @author Javier Mart�n Moreno-Manzanaro
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
