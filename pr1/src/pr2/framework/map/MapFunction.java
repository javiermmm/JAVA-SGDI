/**
 * Interfaz que será implementada en las MapFunction de los ejercicios concretos
 */
package pr2.framework.map;

import java.util.ArrayList;

import pr2.Pareja;


/**
 * @author Javier Martín Moreno-Manzanaro
 */
public interface MapFunction {
	
	public void map (Object clave, Object valor, ArrayList<Pareja> salida);
}
