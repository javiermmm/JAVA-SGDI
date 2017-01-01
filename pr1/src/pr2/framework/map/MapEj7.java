/**
 * Clase que implementa la función Map concreta para el ejercicio 7 de la práctica
 */
package pr2.framework.map;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class MapEj7 implements MapFunction {

	@Override
	public void map(Object clave, Object valor, ArrayList<Pareja> salida) {
		StringTokenizer tk = new StringTokenizer((String)valor, "\t");
		String word = tk.nextToken();
		tk.nextToken();
		String hapinessRank = tk.nextToken();
		tk.nextToken();
		String twitterRank = tk.nextToken();
		
		float felicidad = Float.parseFloat(hapinessRank);
		
		if ((felicidad < 2) && (! twitterRank.equals("--")))
			salida.add(new Pareja(word, "triste"));

	}

}
