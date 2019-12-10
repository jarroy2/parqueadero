/**
 * 
 */
package parqueadero;

/**
 * @author Jonathan Arroyo
 *
 */
public class Carro {

	private int id, donde;
	private boolean parqueado;

	public Carro(int id, int donde, boolean parqueado) {
		super();
		this.id = id;
		this.donde = donde;
		this.parqueado = parqueado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDonde() {
		return donde;
	}

	public void setDonde(int donde) {
		this.donde = donde;
	}

	public boolean isParqueado() {
		return parqueado;
	}

	public void setParqueado(boolean parqueado) {
		this.parqueado = parqueado;
	}

}
