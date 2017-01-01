/**
 * Clase que se encarga de realizar la ditribucion de parejas entre 
 * la salida de los nodosMap y las entrada de los nodosReduce. Este reparto se realiza
 * utilizando los hashCode de las claves de las parejas, por lo que nos aseguramos de que
 * parejas con la misma clave vayan a parar al mismo NodoReduce.
 */
package pr2.framework;

import java.util.ArrayList;
import java.util.Iterator;

import pr2.Pareja;
import pr2.framework.map.NodoMap;
import pr2.framework.reduce.NodoReduce;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class Particionador {

	public void distribuye(NodoMap[] nodosMap, NodoReduce[] nodosReduce) {
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("***************** FASE DE PARTICIONADO *******************");
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------------------------------------");
		
		//Para cada nodoMap...
		for (int i=0; i<nodosMap.length; i++){
			
			ArrayList<Pareja> salidaMap = nodosMap[i].getSalidaMap();
			Iterator<Pareja> iterador = salidaMap.iterator();
			
			//...recorremos su buffer de salida
			while (iterador.hasNext()) {
				Pareja actual = iterador.next();
				
				//Calculamos el nodo reduce al que debe dirigirse la pareja
				int hash = Math.abs(actual.getClave().hashCode() % nodosMap.length);
				
				//Añadimos la pareja al buffer de entrada del nodo Reduce correspondiente
				nodosReduce[hash].addEntrada(actual);
				
				System.out.println("La pareja " + actual.toString() + " del nodo MAP " + i + ", va al nodo REDUCE " + hash);
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Se acaba de ejecutar el Particionador. Tareas distribuidas");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println("----------------------------------------------------------");
	}

}
