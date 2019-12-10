/**
 * 
 */
package parqueadero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author Jonathan Arroyo
 *
 */
public class Principal {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s;
	StringTokenizer st;

	public static void main(String args[]) {
		try {
			new Principal().iniciar();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void iniciar() throws NumberFormatException, IOException {
		int casos;
		casos = Integer.parseInt(br.readLine());
		boolean primerCaso = true;
		while (casos-- != 0) {
			ArrayList<Carro> carros = new ArrayList<Carro>();
			if (primerCaso) {

				br.readLine();
			}

			primerCaso = false;
			int id;
			for (id = Integer.parseInt(br.readLine()); id != 99; id = Integer.parseInt(br.readLine())) {
				carros.add(new Carro(id, id, false));
			}

			s = br.readLine();
			while (s != null && !s.equals("")) {

				int salio = Integer.parseInt(s);

				int posClosest = 9999;
				int minDistance = 9999;
				for (int i = 0; i < carros.size(); ++i) {
					int d;
					if (!carros.get(i).isParqueado()) {
						if (carros.get(i).getDonde() <= salio) {
							d = salio - carros.get(i).getDonde();
						} else {
							d = (salio + 20) - carros.get(i).getDonde();
						}
						if (d < minDistance) {
							minDistance = d;
							posClosest = i;
						}

					}

				}

				if (posClosest == 9999) {
					continue;
				}

				carros.get(posClosest).setParqueado(true);
				carros.get(posClosest).setDonde(salio);

				for (int i = 0; i < carros.size(); ++i) {
					if (!carros.get(i).isParqueado()) {
						int d = carros.get(i).getDonde() + minDistance;
						while (d > 20) {
							d -= 20;
						}
						carros.get(i).setDonde(d);
					}
				}
				s = br.readLine();
			}
			for (int i = 0; i < carros.size(); ++i) {
				System.out.print("El auto de la posición inicial ");
				System.out.print(carros.get(i).getId());
				System.out.print(" ");
				if (carros.get(i).isParqueado()) {
					System.out.print("aparcó en ");
					System.out.print(carros.get(i).getDonde());
					System.out.print("\n");
				} else {
					System.out.print("no aparcó");
					System.out.print("\n");
				}
			}

		}
	}
}
