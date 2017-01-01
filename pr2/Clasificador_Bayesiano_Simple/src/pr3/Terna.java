/**
 * 
 */
package pr3;

/**
 * @author Javi
 *
 */
public class Terna {

	
	//ATRIBUTOS
	private int _posicion;
	private String _valorAtributo;
	private String _clase;

	
	
	public Terna (int pos, String val, String clase) {
		_posicion = pos;
		_valorAtributo = val;
		_clase = clase;
	}
	
	public boolean equals(Object o){
		Terna otra = (Terna) o;
		
		boolean claseIgual = (otra._clase.equals(_clase));
		boolean valorAtributoIgual = (otra._valorAtributo.equals(_valorAtributo));
		boolean posicionIgual = (otra._posicion ==_posicion);
		
		return claseIgual && valorAtributoIgual && posicionIgual;
	}
	
	public int hashCode() {
		int code = _posicion + _valorAtributo.length() + _clase.length();
		return code;
	}
	
	public void setPosicion(int pos){
		_posicion = pos;
	}
	
	public void setValorAtributo(String val){
		_valorAtributo = val;
	}
	
	public void setClase(String clase){
		_clase = clase;
	}
	
	public int getPosicion(){
		return _posicion;
	}
	
	public String getValorAtributo(){
		return _valorAtributo;
	}
	
	public String getClase(){
		return _clase;
	}
}
