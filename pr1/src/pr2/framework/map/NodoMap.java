/**
 * Clase que representa a un nodo Map, 
 * y que contiene su numero de nodo, 
 * su buffer de salida, y la funci�n Map que ejecutar�
 */
package pr2.framework.map;

import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Mart�n Moreno-Manzanaro
 *
 */
public class NodoMap {

	private MapFunction _mapFunction;
	private ArrayList<Pareja> _salidaMap;
	private int _numNodo;
	
	
	public NodoMap (MapFunction f, int numero){
		_numNodo = numero;
		_mapFunction = f;
		_salidaMap = new ArrayList<Pareja>();
	}
	
	
	public void map (Object clave, Object valor) {
		_mapFunction.map(clave, valor, _salidaMap);
	}
	
	
	public int getNumNodo() {
		return _numNodo;
	} 
	
	
	public ArrayList<Pareja> getSalidaMap() {
		return _salidaMap;
	}
}
