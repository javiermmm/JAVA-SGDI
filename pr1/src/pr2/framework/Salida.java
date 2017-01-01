/**
 * Clase que se encarga de volcar a un fichero de texto las salidas generadas 
 * al realizar la tarea MapReduce leyendolas a partir de un buffer de salida representado
 * como un arrayList de Parejas <clave, valor>
 */
package pr2.framework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import pr2.Pareja;

/**
 * @author Javier Martín Moreno-Manzanaro
 * 
 */
public class Salida {

	
	private FileWriter _fw;
	private BufferedWriter _buffer;
	private ArrayList<Pareja> _parejasSalida;
	
	
	public ArrayList<Pareja> getParejasSalida() {
		return _parejasSalida;
	}
	
	
	public void out(String ficheroSalida) {

		try {
			_fw = new FileWriter(ficheroSalida);
			_buffer = new BufferedWriter(_fw);
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("***********  FASE DE SALIDA  **********");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			System.out.println("Comenzamos el volcado a fichero: ");
			System.out.println();
			System.out.println();
			
			Iterator<Pareja> iterator = _parejasSalida.iterator();
			
			//Mientras queden salidas que leer...
			while (iterator.hasNext()){
				Pareja actual = iterator.next();
				
				//Monto la linea y la escribo en el fichero
				String linea = "<" + actual.getClave() + " , " + actual.getValor() + ">";
				_buffer.write(linea);
				_buffer.write("\n");
				
				System.out.println(linea);
			}
			
			
			_buffer.close();
			_fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		System.out.println("Escritura terminada. Salida generada");
		System.out.println();
	}


	public void setOutput(ArrayList<Pareja> output) {
		_parejasSalida = output;
	}

}
