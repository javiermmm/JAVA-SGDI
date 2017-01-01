/**
 * Clase que implementa la función Reduce concreta para el ejercicio 1 de la práctica
 */
package pr2.framework.reduce;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class ReduceEj1 implements ReduceFunction {

	@Override
	public void reduce(Object clave, Object valor, ArrayList<Pareja> salida) {
		ArrayList<Integer> out = (ArrayList<Integer>) valor;
		salida.add(new Pareja (clave, out.size()));
	}

}
