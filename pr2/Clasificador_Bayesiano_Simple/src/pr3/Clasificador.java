/**
 * 
 */
package pr3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * @author Javi
 * 
 */
public class Clasificador {

	private HashMap<String, Float> _probabilidadesClases;
	private HashMap<Terna, Float> _probabilidadesTernas;
	private HashMap<String, Integer> _aparicionesClase;
	private HashMap<Terna, Integer> _combinaciones;
	private HashSet<String>[] _valoresAtributos;

	
	
	
	//CONSTRUCTOR
	public Clasificador () {
		_probabilidadesClases = new HashMap<String, Float> ();
		_probabilidadesTernas = new HashMap<Terna, Float> ();
		_aparicionesClase = new HashMap<String, Integer>();
		_combinaciones = new HashMap<Terna, Integer>();
	}
	
	//************************
	//      APARTADO 1
	//************************
	public void entrena(String path, int nAtributos) {
		try {
			// Creo los objetos que necesito para leer del fichero
			FileReader fr = new FileReader(path);
			BufferedReader buffer = new BufferedReader(fr);
			String line;

			//Inicializo los contadores de instancias
			int contInstanciasTotales = 0;
			int contInstanciasErroneas = 0;

			// Mientras haya lineas que leer...
			while ((line = buffer.readLine()) != null) {
				//Troceo la linea por comas
				String[] tokens;
				tokens = line.split(",");
				int contTokens = tokens.length;
				//Si la linea está bien formada
				if (contTokens == nAtributos) {
					cuentaApariciones(tokens, contTokens);
				} else
					contInstanciasErroneas++;
				contInstanciasTotales++;
			}

			muestraDatosInstancias(contInstanciasTotales, contInstanciasErroneas);
			calculaProbAparicionesClase(contInstanciasTotales, contInstanciasErroneas);
			inicializaValoresAtributos(nAtributos);
			calculaProbCombinacionesTerna();
			muestraValoresPosiblesDeAtributos();

			buffer.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//************************
	//      APARTADO 2
	//************************
	public void test(String path, int nAtributos) {
		try {
			// Creo los objetos que necesito para leer del fichero
			FileReader fr = new FileReader(path);
			BufferedReader buffer = new BufferedReader(fr);
			String line;

			//Inicializo los contadores de instancias, aciertos y fallos
			int contInstanciasTotales = 0;
			int contInstanciasErroneas = 0;
			int contAciertos = 0;
			int contFallos = 0;

			// Mientras haya lineas que leer...
			while ((line = buffer.readLine()) != null) {

				//Troceo la linea por comas
				String[] tokens;
				tokens = line.split(",");
				int contTokens = tokens.length;
				//Si la linea está bien formada
				if (contTokens == nAtributos) {
					int ultimaComa = line.lastIndexOf(",");
					String instancia = line.substring(0, ultimaComa);
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println("La instancia original es " + line);
					String prediccion = clasifica(instancia, nAtributos);
					System.out.println("La prediccion del clasificador bayesiano es que la instancia pertenece a la clase " + prediccion);
					if (prediccion.equals(tokens[tokens.length-1])){
						contAciertos++;
						System.out.println("La prediccion fue: CORRECTA");
					} else {
						contFallos++;
						System.out.println("La prediccion fue: INCORRECTA");
					}
				} else
					contInstanciasErroneas++;
				contInstanciasTotales++;
			}

			muestraDatosInstancias(contInstanciasTotales, contInstanciasErroneas);
			float tasaAciertos = (float) contAciertos / (contInstanciasTotales - contInstanciasErroneas);
			System.out.println("El indice de acierto ha sido: " + contAciertos + "/" + (contInstanciasTotales - contInstanciasErroneas) + " = " + tasaAciertos);
			
			buffer.close();
			fr.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//************************
	//      APARTADO 3
	//************************
	public String clasifica(String instancia, int nAtributos){
		
		String[] tokens;
		tokens = instancia.split(",");
		HashMap<String, Float> probabilidades = new HashMap<String, Float>();
		
		calculaProbabilidadClasificacionClase(tokens, probabilidades);
		
		return buscaMasProbable(probabilidades);
	}
	
	
	//********************************************************************************
	//********************************************************************************
	//********************************************************************************
	//********************************************************************************
	//********************************************************************************
	
	
	//******************
	//MÉTODOS PRIVADOS
	//******************
	
	private void cuentaApariciones(String[] tokens, int contTokens) {
		String clase = tokens[tokens.length - 1];
		if (_aparicionesClase.containsKey(clase)) {
			int apariciones = _aparicionesClase.get(clase);
			apariciones++;
			_aparicionesClase.put(clase, apariciones);
		} else
			_aparicionesClase.put(clase, 1);

		int i = 0;
		while (i < contTokens - 1) {
			Terna t = new Terna(i, tokens[i], clase);
			if (_combinaciones.containsKey(t)) {
				int apariciones = _combinaciones.get(t);
				apariciones++;
				_combinaciones.put(t, apariciones);
			} else
				_combinaciones.put(t, 1);
			
			i++;
		}
	}
	
	private void muestraDatosInstancias(int contInstanciasTotales, int contInstanciasErroneas) {
		System.out.println();
		System.out.println("Entrada leida");
		System.out.println("----------------------------------------");
		System.out.println("----------------------------------------");
		System.out.println();
		System.out.println();

		System.out.println("Número de instancias totales: " + contInstanciasTotales);
		System.out.println("Número de instancias mal formadas: " + contInstanciasErroneas);
		
		
		
	}
	
	private void calculaProbAparicionesClase(int contInstanciasTotales, int contInstanciasErroneas) {
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Lista de clases:");
		System.out.println();
		
		
		Iterator it = _aparicionesClase.entrySet().iterator();
		while (it.hasNext()) {
			Entry e = (Entry) it.next();
			String clase= (String) e.getKey();
			int apariciones = (int) e.getValue();
			float probabilidad = (float) apariciones / (contInstanciasTotales - contInstanciasErroneas);
			_probabilidadesClases.put(clase, probabilidad);
			System.out.println("Clase: " + clase + "   --->   Probabilidades: " + apariciones + "/" + (contInstanciasTotales - contInstanciasErroneas) + " = " + probabilidad);
		}
	}
	
	private void calculaProbCombinacionesTerna() {
		Iterator iter = _combinaciones.entrySet().iterator();
		while (iter.hasNext()) {
			Entry e = (Entry) iter.next();
			Terna t = (Terna) e.getKey();
			_valoresAtributos[t.getPosicion()].add(t.getValorAtributo());
			String clase = t.getClase();
			int aparicionesClase = _aparicionesClase.get(clase);
			int numCombinaciones = (int) e.getValue();
			float probabilidad = (float) numCombinaciones / aparicionesClase;
			_probabilidadesTernas.put(t, probabilidad);
			System.out.println("(Clase: " + clase + ", posicion del atributo: " + t.getPosicion() + ", Valor: " + t.getValorAtributo() + "    --->   Probabilidades: " + numCombinaciones + "/" + aparicionesClase + " = " + probabilidad);
		}
	}
	
	private void inicializaValoresAtributos(int nAtributos) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Lista de Atributos:");
		System.out.println();
		_valoresAtributos = new HashSet[nAtributos];
		for (int i = 0; i<_valoresAtributos.length-1; i++){
			_valoresAtributos[i] = new HashSet<String>();
		}
	}
	
	private void muestraValoresPosiblesDeAtributos() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Valores posibles");
		System.out.println();
		for (int i = 0; i<_valoresAtributos.length-1; i++){
			System.out.println("Los valores encontrados para el atributo de la posicion " + i + " son: " + _valoresAtributos[i]);
		}
	}
	
	private void calculaProbabilidadClasificacionClase(String[] tokens, HashMap<String, Float> probabilidades) {
		float acum = 1;
		Iterator it = _aparicionesClase.entrySet().iterator();
		while (it.hasNext()) {
			Entry e = (Entry) it.next();
			String clase= (String) e.getKey();
			acum = 1;
			for (int i = 0; i<tokens.length; i++){
				Terna t = new Terna(i, tokens[i], clase);
				boolean esta = _probabilidadesTernas.containsKey(t);
				if (esta) {
					float aux = _probabilidadesTernas.get(t);
					acum = acum * aux;
				}
				else
					acum = 0;
			}
			acum = acum * _probabilidadesClases.get(clase);
			probabilidades.put(clase, acum);
			System.out.println("La probabilidad de que la instancia actual sea de clase " + clase + " es de " + acum);
		}
	}
	
	private String buscaMasProbable(HashMap<String, Float> probabilidades) {
		String ret = null;
		float mayor = -999999999;
		Iterator iter = probabilidades.entrySet().iterator();
		while (iter.hasNext()){
			Entry e = (Entry) iter.next();
			String clase= (String) e.getKey();
			float prob= (float) e.getValue();
			if (prob > mayor) {
				mayor = prob;
				ret = clase;
			}
		}
		
		return ret;
	}
}
