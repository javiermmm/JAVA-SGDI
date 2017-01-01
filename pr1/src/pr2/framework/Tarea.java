/**
 * Clase que se encarga de orquestar la tarea MapReduce que se realiza, 
 * estableciendo las distintas fases de entrada, Map, Particionado, Ordenado, Reduce y Salida
 */
package pr2.framework;

import java.util.ArrayList;
import java.util.Iterator;

import pr2.Pareja;
import pr2.framework.map.MapFunction;
import pr2.framework.map.NodoMap;
import pr2.framework.reduce.NodoReduce;
import pr2.framework.reduce.ReduceFunction;

/**
 * @author Javier Martín Moreno-Manzanaro
 * 
 */
public class Tarea {

	
	private String _inputFile;
	private String _outputFile;
	private int _numNodos;
	private NodoMap[] _nodosMap;
	private NodoReduce[] _nodosReduce;
	private MapFunction _mapFunction;
	private ReduceFunction _reduceFunction;

	
	
	
	public void setInputFile(String entrada) {
		_inputFile = entrada;
	}

	
	public void setOutputFile(String salida) {
		_outputFile = salida;
	}

	
	public void setNodes(int nodos) {
		_numNodos = nodos;
	}

	
	public void setMapFunction(MapFunction mapFunction) {
		_mapFunction = mapFunction;
	}

	
	public void setReduceFunction(ReduceFunction reduceFunction) {
		_reduceFunction = reduceFunction;
	}
	
	
	public void run() {

		// creamos los array de nodos
		_nodosMap = new NodoMap[_numNodos];
		_nodosReduce = new NodoReduce[_numNodos];

		// -----------------
		// ENTRADA
		// -----------------
		// Cargo el fichero
		Entrada entrada = new Entrada();
		entrada.load(_inputFile);

		// ----------------
		// MAP
		// ----------------
		lanzaMaps(entrada);

		// -----------------
		// PARTICIONADO
		// -----------------
		Particionador particionador = new Particionador();
		particionador.distribuye(_nodosMap, _nodosReduce);

		// -----------------
		// ORDENADO
		// -----------------
		ordenaEntradasReduce();

		// -----------------
		// REDUCE
		// -----------------
		ArrayList<Pareja> output = new ArrayList<Pareja>();
		lanzaReduces(output);
		
		// -----------------
		// SALIDA
		// -----------------
		// Vuelco a fichero
		Salida salida = new Salida();
		salida.setOutput(output);
		salida.out(_outputFile);
	}

	
	private void lanzaMaps(Entrada entrada) {

		System.out.println();
		System.out.println();
		System.out.println("*************  FASE DE MAP  ************");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		ArrayList<Pareja> input = entrada.getParejasEntrada();
		Iterator<Pareja> iterator = input.iterator();

		// Para cada nodo...
		for (int i = 0; i < _numNodos; i++) {
			System.out.println();
			// ...creo el i-ésimo nodo map y reduce...
			NodoMap nodoM = new NodoMap(_mapFunction, i);
			NodoReduce nodoR = new NodoReduce(_reduceFunction, i);
			_nodosMap[i] = nodoM;
			_nodosReduce[i] = nodoR;
			// ...Establezco la carga de cada nodo...
			int numEntradasMap = entrada.reparte(_numNodos);
			
			// ... y mientras le quede carga de trabajo a ese nodo...
			while ((numEntradasMap > 0) && (iterator.hasNext())) {
				System.out.println();
				System.out.println();
				System.out.println("Aplicando funcion map en el nodo " + i);
				Pareja actual = iterator.next();
				System.out.println("Pareja antes de ejecutar MAP:  " + actual.toString());
				// ...aplico la funcion Map en el nodo y decremento su carga de trabajo
				nodoM.map(actual.getClave(), actual.getValor());
				numEntradasMap--;
				System.out.println("Quedan " + numEntradasMap + " entradas map, en este nodo [" + i + "]");
			}
		}

		// Después de este reparto por "bloques", pueden quedar algunas
		// entradas, así que las reasigno
		// dando una a cada nodo para mantener la carga balanceada.
		while (iterator.hasNext()) {
			Pareja actual = iterator.next();
			// Con esta linea, miro las entradas que me quedan 
			// y les asigno un nodo de manera "circular"
			int index = (input.size() - (int) actual.getClave()) % _numNodos;
			_nodosMap[index].map(actual.getClave(), actual.getValor());
		}
	}

	private void ordenaEntradasReduce() {

		System.out.println();
		System.out.println();
		System.out.println("***********  FASE DE ORDENADO  *********");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println();

		// Para cada nodo Reduce
		for (int i = 0; i < _nodosReduce.length; i++) {
			System.out.println("Ordenando la entrada reduce del nodo " + i);
			// Preparamos su buffer de entrada para que contenga parejas <clave, lista_de_valores>
			_nodosReduce[i].prepara();
			System.out.println();
		}
	}

	private void lanzaReduces(ArrayList<Pareja> output) {

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("************* FASE DE REDUCE ***********");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		

		// Para cada nodo reduce...
		for (int i = 0; i < _numNodos; i++) {
			ArrayList<Pareja> entradaReduce = _nodosReduce[i].getEntradaReduce();
			Iterator<Pareja> iterador = entradaReduce.iterator();

			// ...recorremos sus entradas...
			while (iterador.hasNext()) {
				Pareja actual = iterador.next();
				System.out.println();
				System.out.println("Pareja de entrada: " + actual.toString());
				System.out.println("Aplicando funcion reduce en el nodo " + i);
				System.out.println();
				// ... aplicando la funcion reduce
				_nodosReduce[i].reduce(actual.getClave(), actual.getValor(), output);
			}
		}
	}
}
