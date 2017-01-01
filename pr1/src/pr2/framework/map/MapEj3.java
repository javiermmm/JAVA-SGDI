/**
 * Clase que implementa la función Map concreta para el ejercicio 3 de la práctica
 */
package pr2.framework.map;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class MapEj3 implements MapFunction {

	@Override
	public void map(Object clave, Object valor, ArrayList<Pareja> salida) {
		// TODO Auto-generated method stub
		String linea = (String) valor;
		int primerCorchete = linea.indexOf("[");
		int ultimoCorchete = linea.indexOf("]");
		String fecha = linea.substring(primerCorchete+1, ultimoCorchete);
		int primerosDosPuntos = fecha.indexOf(":");
		int segundosDosPuntos = fecha.indexOf(":", primerosDosPuntos+1);
		String hora = fecha.substring(primerosDosPuntos+1, segundosDosPuntos);

		System.out.println("Línea número " + clave);
		System.out.println("Hora: " + hora);
		salida.add(new Pareja (hora, 1));
	}

}
