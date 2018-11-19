package grafo;

public class MatrizAdyacencia {
	
	private int[][] matriz;

	public MatrizAdyacencia(int cantNodos) {
		this.matriz = new int[cantNodos][cantNodos];
	}

	
	public void setUnion(int fila, int columna) {
		this.matriz[fila][columna] = 1;
	}
	
	
	public int getUnion(int fila,int columna) {
		return this.matriz[fila][columna];
	}

}
