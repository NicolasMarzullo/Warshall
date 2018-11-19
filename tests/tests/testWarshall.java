package tests;

import org.junit.Test;

import grafo.Grafo;

public class testWarshall {

	@Test
	public void testCasoEnClase() {

		Grafo gFloyd = new Grafo(3);

		gFloyd.setUnion(0, 1);
//		gFloyd.setUnion(0, 2);
		gFloyd.setUnion(1, 0);
		gFloyd.setUnion(2, 1);

		int[][] resultado = gFloyd.calcularFloyd();

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado.length; j++) {
				System.out.print(resultado[i][j] + "  ");
			}
			System.out.println();
		}

	}
}
