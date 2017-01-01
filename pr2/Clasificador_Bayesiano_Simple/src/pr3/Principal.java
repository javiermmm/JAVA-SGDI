/**
 * 
 */
package pr3;

/**
 * @author Javi
 *
 */
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Clasificador c = new Clasificador();
		
		System.out.println();
		System.out.println();
		System.out.println("UTILIZAMOS LA FUNCIÓN DE ENTRENAMIENTO Y MOSTRAMOS ALGUNOS DATOS");
		System.out.println();
		c.entrena("car_half.data", 7);
		
		
		System.out.println();
		System.out.println();
		System.out.println("UTILIZAMOS LA FUNCIÓN DE TEST, MOSTRANDO LAS PREDICCIONES PARA CADA INSTANCIA");
		System.out.println();
		c.test("test.data", 7);
		
		
		System.out.println();
		System.out.println();
		System.out.println("POR ÚLTIMO, MOSTRAMOS EL RESULTADO DE UNA EJECUCIÓN AISLADA DE LA FUNCIÓN CLASIFICA, CON UNA INSTANCIA AL AZAR (CABLEADA), COMO HEMOS HECHO EN LA FUNCIÓN ANTERIOR");
		System.out.println();
		System.out.println("La clase de la instancia introducida es:   ---" + c.clasifica("low,low,5more,more,big,high", 7) + "---");
	}

}
