package grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {

	private List<Nodo> nodos = new ArrayList<>();
	private int cantDeNodos;
	private MatrizAdyacencia matrizAdyacencia;

	public Grafo(int cantDeNodos) {

		for (int i = 0; i < cantDeNodos; i++) {
			this.nodos.add(new Nodo(i));
		}
		this.cantDeNodos = cantDeNodos;
		this.matrizAdyacencia = new MatrizAdyacencia(cantDeNodos);
	}

	public void setUnion(int fila, int columna) {
		this.matrizAdyacencia.setUnion(fila, columna);
	}

	public int[][] calcularFloyd() {
		int[][] matrizDeCaminosDisponibles = new int[cantDeNodos][cantDeNodos];

		//Cargo una auxiliar, la original no la toco.
		for (int i = 0; i < this.cantDeNodos; i++) {
			for (int j = 0; j < this.cantDeNodos; j++) {
				matrizDeCaminosDisponibles[i][j] = this.matrizAdyacencia.getUnion(i, j);
			}
		}

		for (int k = 0; k < this.cantDeNodos; k++) {
			for (int i = 0; i < this.cantDeNodos; i++) {
				for (int j = 0; j < this.cantDeNodos; j++) {
					// Si antes no habia forma de llegar, y ahora, pasando por un nodo intermedio,
					// puedo llegar, entonces hay camino
					if (i != j && i != k && j != k && matrizDeCaminosDisponibles[i][j] == 0
							&& (matrizDeCaminosDisponibles[i][k] == 1 && matrizDeCaminosDisponibles[k][j] == 1))
						matrizDeCaminosDisponibles[i][j] = 1;
				}
			}

		}

		return matrizDeCaminosDisponibles;
	}

}
