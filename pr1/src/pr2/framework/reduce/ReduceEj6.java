/**
 * Clase que implementa la función Reduce concreta para el ejercicio 6 de la práctica
 */
package pr2.framework.reduce;

import java.util.ArrayList;
import java.util.Iterator;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class ReduceEj6 implements ReduceFunction {

	@Override
	public void reduce(Object clave, Object valor, ArrayList<Pareja> salida) {
		ArrayList<Float> out = (ArrayList<Float>) valor;
		float min = 99999999;
		float max = -99999999;
		Iterator<Float> it = out.iterator();
		while (it.hasNext()) {
			float actual = it.next();
			if (actual > max)
				max = actual;
			if (actual < min)
				min = actual;
		}
		
		String minYMax = "(" + min + ", " + max + ")";
		salida.add(new Pareja (clave, minYMax));
	}

}
