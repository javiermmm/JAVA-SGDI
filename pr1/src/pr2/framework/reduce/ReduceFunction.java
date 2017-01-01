/**
 * Interfaz que será implementada por las reduceFunction de los ejercicios concretos
 */
package pr2.framework.reduce;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public interface ReduceFunction {

	public void reduce (Object clave, Object valor, ArrayList<Pareja> salida);
}
