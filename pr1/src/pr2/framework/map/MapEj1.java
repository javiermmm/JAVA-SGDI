/**
 * Clase que implementa la funci�n Map concreta para el ejercicio 1 de la pr�ctica
 */
package pr2.framework.map;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Mart�n Moreno-Manzanaro
 */
public class MapEj1 implements MapFunction {

	@Override
	public void map(Object clave, Object valor, ArrayList<Pareja> salida) {
		
		String linea = (String) valor;
		int ultimasComillas = linea.lastIndexOf("\"");
		int ultimoBlanco = linea.lastIndexOf(" ");
		String codigo = linea.substring(ultimasComillas+2, ultimoBlanco);
		
		System.out.println("L�nea n�mero " + clave);
		System.out.println("C�digo HTTP le�do: " + codigo);
		
		if (codigo.equals("404"))
			salida.add(new Pareja ("404", 1));
		
	}
}
