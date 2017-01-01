/**
 * Clase que representa a un nodo Reduce, 
 * y que contiene su numero de nodo, 
 * su buffer de entrada, y la función Reduce que ejecutará
 */
package pr2.framework.reduce;

import java.util.ArrayList;
import java.util.Iterator;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 * 
 */
public class NodoReduce {

	private ReduceFunction _reduceFunction;
	private ArrayList<Pareja> _entradaReduce;
	private int _numNodo;

	public NodoReduce(ReduceFunction f, int numero) {
		_numNodo = numero;
		_reduceFunction = f;
		_entradaReduce = new ArrayList<Pareja>();
	}

	public void reduce(Object clave, Object valor, ArrayList<Pareja> salida) {
		_reduceFunction.reduce(clave, valor, salida);
	}

	public int getNumNodo() {
		return _numNodo;
	}

	public void addEntrada(Pareja actual) {
		_entradaReduce.add(actual);
	}

	public ArrayList<Pareja> getEntradaReduce() {
		return _entradaReduce;
	}

	public void prepara() {
		ArrayList<Pareja> entradaOrdenada = new ArrayList<Pareja>();
		System.out.println("La entrada del Reduce ANTES de ordenar es:");
		System.out.println(_entradaReduce);
		while (!_entradaReduce.isEmpty()) {
			Iterator<Pareja> it = _entradaReduce.iterator();

			Pareja actual = it.next();
			String clave = (String) actual.getClave();
			Object valor = actual.getValor();
			ArrayList<Object> valores = new ArrayList<Object>();
			valores.add(valor);
			it.remove();
			
			while (it.hasNext()) {
				Pareja otra = it.next();
				String otraClave = (String) otra.getClave();
				if (otraClave.equals(clave)) {
					valores.add(otra.getValor());
					it.remove();
				}
			}
			entradaOrdenada.add(new Pareja(clave, valores));
		}
		
		_entradaReduce = entradaOrdenada;
		System.out.println("La entrada del Reduce DESPUÉS de ordenar es:");
		System.out.println(_entradaReduce);
	}
}
