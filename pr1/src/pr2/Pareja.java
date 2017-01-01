/**
 * Clase Pareja que almacena dos valores de cualquier tipo (Object), 
 * identificándolos como clave y valor de la pareja
 */
package pr2;

/**
 * @author Javier Martín Moreno-Manzanaro
 * 
 */
public class Pareja {

	private Object _clave;
	private Object _valor;

	public Pareja(Object first, Object second) {
		_clave = first;
		_valor = second;
	}

	/**************************
	 * ACCEDENTES Y MUTADORES 
	 * ************************
	*/
	public Object getClave() {
		return _clave;
	}

	public void setClave(Object val) {
		_clave = val;
	}

	public Object getValor() {
		return _valor;
	}

	public void setValor(Object val) {
		_valor = val;
	}
	
	
	/*
	 *******************************
	 * MÉTODOS SOBREESCRITOS
	 * *****************************
	*/
	@Override
	public String toString() {
		return "<" + _clave + ", " + _valor + ">";
	}
	
	public int hashCode() {
		return _clave.hashCode();
	}
}