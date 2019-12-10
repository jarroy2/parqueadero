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
	private boolean parked;

	public Carro(int id, int donde, boolean parked) {
		super();
		this.id = id;
		this.donde = donde;
		this.parked = parked;
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

	public boolean isParked() {
		return parked;
	}

	public void setParked(boolean parked) {
		this.parked = parked;
	}

}
