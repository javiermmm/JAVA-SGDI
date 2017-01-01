/**
 * Clase que implementa la funci�n Reduce concreta para el ejercicio 1 de la pr�ctica
 */
package pr2.framework.reduce;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Mart�n Moreno-Manzanaro
 *
 */
public class ReduceEj1 implements ReduceFunction {

	@Override
	public void reduce(Object clave, Object valor, ArrayList<Pareja> salida) {
		ArrayList<Integer> out = (ArrayList<Integer>) valor;
		salida.add(new Pareja (clave, out.size()));
	}

}
