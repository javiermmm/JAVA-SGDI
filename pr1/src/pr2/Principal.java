/**
 * Clase Principal que contiene el main.
 */
package pr2;

import pr2.framework.Tarea;
import pr2.framework.map.*;
import pr2.framework.reduce.*;

/**
 * @author Javier Martín Moreno-Manzanaro
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Tarea t = new Tarea();
		
		
		//EJERCICIO 1
		t.setInputFile("weblog.txt");
		t.setOutputFile("outputEx1.txt");
		t.setNodes(19);
		MapFunction mapFunction = new MapEj1();
		t.setMapFunction(mapFunction);
		ReduceFunction reduceFunction = new ReduceEj1();
		t.setReduceFunction(reduceFunction);
		t.run();
		
		

		/*
		//EJERCICIO 2
		t.setInputFile("weblog.txt");
		t.setOutputFile("outputEx2.txt");
		t.setNodes(57);
		MapFunction mapFunction = new MapEj2();
		t.setMapFunction(mapFunction);
		ReduceFunction reduceFunction = new ReduceEj2();
		t.setReduceFunction(reduceFunction);
		t.run();
		*/

		
		/*
		//EJERCICIO 3
		t.setInputFile("weblog.txt");
		t.setOutputFile("outputEx3.txt");
		t.setNodes(31);
		MapFunction mapFunction = new MapEj3();
		t.setMapFunction(mapFunction);
		ReduceFunction reduceFunction = new ReduceEj3();
		t.setReduceFunction(reduceFunction);
		t.run();
		*/
		
		/*
		//EJERCICIO 4
		t.setInputFile("JCMB_last31days.csv");
		t.setOutputFile("outputEx4.txt");
		t.setNodes(23);
		MapFunction mapFunction = new MapEj4();
		t.setMapFunction(mapFunction);
		ReduceFunction reduceFunction = new ReduceEj4();
		t.setReduceFunction(reduceFunction);
		t.run();
		*/
		
		/*
		//EJERCICIO 5
		t.setInputFile("JCMB_last31days.csv");
		t.setOutputFile("outputEx5.txt");
		t.setNodes(36);
		MapFunction mapFunction = new MapEj5();
		t.setMapFunction(mapFunction);
		ReduceFunction reduceFunction = new ReduceEj5();
		t.setReduceFunction(reduceFunction);
		t.run();
		*/
		
		/*
		//EJERCICIO 6
		t.setInputFile("JCMB_last31days.csv");
		t.setOutputFile("outputEx6.txt");
		t.setNodes(6);
		MapFunction mapFunction = new MapEj6();
		t.setMapFunction(mapFunction);
		ReduceFunction reduceFunction = new ReduceEj6();
		t.setReduceFunction(reduceFunction);
		t.run();
		*/
		
		/*
		//EJERCICIO 7
		t.setInputFile("happiness.txt");
		t.setOutputFile("outputEx7.txt");
		t.setNodes(15);
		MapFunction mapFunction = new MapEj7();
		t.setMapFunction(mapFunction);
		ReduceFunction reduceFunction = new ReduceEj7();
		t.setReduceFunction(reduceFunction);
		t.run();
		*/
	}

}
