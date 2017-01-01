/**
 * Clase que implementa la funci�n Reduce concreta para el ejercicio 2 de la pr�ctica
 */
package pr2.framework.reduce;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Mart�n Moreno-Manzanaro
 *
 */
public class ReduceEj2 implements ReduceFunction {

	@Override
	public void reduce(Object clave, Object valor, ArrayList<Pareja> salida) {
		Pareja p = new Pareja (clave, valor);
		System.out.println("Pareja de entrada de Reduce:" + p.toString());
		ArrayList<Integer> out = (ArrayList<Integer>) valor;
		Pareja nueva = new Pareja (clave, out.size());
		salida.add(nueva);
		System.out.println("Salida de Reduce:" + nueva.toString());
	}

}
