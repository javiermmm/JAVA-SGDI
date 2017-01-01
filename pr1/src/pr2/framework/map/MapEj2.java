/**
 * Clase que implementa la función Map concreta para el ejercicio 2 de la práctica
 */
package pr2.framework.map;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class MapEj2 implements MapFunction{

	@Override
	public void map(Object clave, Object valor, ArrayList<Pareja> salida) {

		String linea = (String) valor;
		int ultimasComillas = linea.lastIndexOf("\"");
		int primerasComillas = linea.indexOf("\"");
		String request = linea.substring(primerasComillas+2, ultimasComillas);
		int hayGif = request.lastIndexOf(".gif");
		int hayGIF = request.lastIndexOf(".GIF");

		System.out.println("Línea número " + clave);
		
		if ((hayGif != -1) || (hayGIF != -1)){
			System.out.println("Hay GIF");
			Pareja p = new Pareja ("gif", 1);
			salida.add(p);
			System.out.println("Salida del MAP: " + p.toString());
		}
		else
			System.out.println("NO hay GIF");
	}

}
