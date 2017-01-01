/**
 * Clase que implementa la función Map concreta para el ejercicio 1 de la práctica
 */
package pr2.framework.map;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 */
public class MapEj1 implements MapFunction {

	@Override
	public void map(Object clave, Object valor, ArrayList<Pareja> salida) {
		
		String linea = (String) valor;
		int ultimasComillas = linea.lastIndexOf("\"");
		int ultimoBlanco = linea.lastIndexOf(" ");
		String codigo = linea.substring(ultimasComillas+2, ultimoBlanco);
		
		System.out.println("Línea número " + clave);
		System.out.println("Código HTTP leído: " + codigo);
		
		if (codigo.equals("404"))
			salida.add(new Pareja ("404", 1));
		
	}
}
