/**
 * Clase que implementa la función Reduce concreta para el ejercicio 7 de la práctica
 */
package pr2.framework.reduce;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class ReduceEj7 implements ReduceFunction {

	@Override
	public void reduce(Object clave, Object valor, ArrayList<Pareja> salida) {
		salida.add(new Pareja (clave, valor));
	}

}
