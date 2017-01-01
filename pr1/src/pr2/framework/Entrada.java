/**
 * Clase que lee las entradas de un fichero y las almacena en un buffer de entrada
 * identificado con un arrayList de Parejas <numero_de_linea, linea>
 */
package pr2.framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class Entrada {

	private FileReader _fr;
	private BufferedReader _buffer;
	private ArrayList<Pareja> _parejasEntrada;
	
	public ArrayList<Pareja> getParejasEntrada() {
		return _parejasEntrada;
	}
	
	public void load(String ficheroEntrada) {

		_parejasEntrada = new ArrayList<Pareja>();
		
		try {
			// Creo los objetos que necesito para leer del fichero
			_fr = new FileReader(ficheroEntrada);
			_buffer = new BufferedReader(_fr);

			String line;
			int i = 0;

			System.out.println("***********  FASE DE ENTRADA  **********");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			System.out.println("Comenzamos a leer la entrada: ");
			System.out.println();
			// Mientras haya lineas que leer, la guardo y la pinto
			while ((line = _buffer.readLine()) != null) {
				
				Pareja pareja = new Pareja(i, line);
				_parejasEntrada.add(pareja);
				
				if (i<3) //Muestro solo las 3 primeras para no abarrotar la consola
					System.out.println(i + "        " + pareja.toString());
				i++;
			}
			System.out.println("...");
			System.out.println("...");
			System.out.println("...");
			
			_buffer.close();
			_fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("Entrada leida");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println();
	}
	
	/*
	 * Método para repartir la carga de trabajo. Calculamos un reparto "por bloques" dividiendo
	 * las entradas entre los nodos disponibles. Si hay menos de las primeras que de los segundos
	 * asignamos una unica pareja como carga de trabajo
	*/
	public int reparte(int _numNodos){
		if (_parejasEntrada.size() < _numNodos)
			return 1;
		else
			return (_parejasEntrada.size() / _numNodos);
	}

}
