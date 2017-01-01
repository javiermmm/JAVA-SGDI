/**
 * Clase que implementa la función Map concreta para el ejercicio 5 de la práctica
 */
package pr2.framework.map;

import java.util.ArrayList;
import java.util.StringTokenizer;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class MapEj5 implements MapFunction {

	@Override
	public void map(Object clave, Object valor, ArrayList<Pareja> salida) {
		
		StringTokenizer tk = new StringTokenizer((String)valor, ",");
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		String rainfall = tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		String relativeHumidity = tk.nextToken();
		tk.nextToken();
		tk.nextToken();
		String sensacionTermica = tk.nextToken();
		
		float precipitaciones = Float.parseFloat(rainfall);
		String terna = "(" + precipitaciones + ", " + relativeHumidity + ", " + sensacionTermica + ")";
		
		if (precipitaciones > 0)
			salida.add(new Pareja(String.valueOf(clave), terna));
	}

}
