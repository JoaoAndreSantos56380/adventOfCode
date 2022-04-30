package desafio_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * HydrothermalVenture
 */
public class HydrothermalVenture {
	private static String ficheiroInput = "input.txt";
	private static String ficheiroInputTeste = "inputTeste.txt";

	public static void main(String[] args) throws FileNotFoundException {
		String line;
		String[] lineArr;
		Diagram diagrama = new Diagram();
		//PrintWriter pw = new PrintWriter(new File("matriz.txt"));
		try (BufferedReader br = new BufferedReader(new FileReader(new File(ficheiroInput)))) {
			while ((line = br.readLine()) != null) {
				lineArr = line.split("\\,| \\-\\> ");
				if (Integer.parseInt(lineArr[0]) == Integer.parseInt(lineArr[2])) {
					// An entry like 9,7 -> 7,7 covers points 9,7, 8,7, and 7,7.
					diagrama.escreveVertical(Integer.parseInt(lineArr[0]),Integer.parseInt(lineArr[1]) ,Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));
					//printArr(lineArr);escreveVertical
					//diagrama.print();
					//diagrama.reset();
					//System.out.println();
				} else if (Integer.parseInt(lineArr[1]) == Integer.parseInt(lineArr[3])) {
				// An entry like 1,1 -> 1,3 covers points 1,1, 1,2, and 1,3.
					diagrama.escreveHorizontal(Integer.parseInt(lineArr[0]),Integer.parseInt(lineArr[1]) ,Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));
					//printArr(lineArr);
					//diagrama.print();
					//diagrama.reset();
					//System.out.println();
				} else{
					diagrama.escreveDiagonal(Integer.parseInt(lineArr[0]),Integer.parseInt(lineArr[1]) ,Integer.parseInt(lineArr[2]), Integer.parseInt(lineArr[3]));
					//printArr(lineArr);
					//diagrama.print();
					//diagrama.reset();
					//System.out.println();
				}
			}
		} catch (IOException e) {
			// e.printStackTrace();
			System.out.println("No file found!");
		}
		// ler linha a linha
		System.out.println("Final!");
		int numero = diagrama.twoLinesOverlap();
		System.out.println(numero);
		//diagrama.print();

		/*
		* String teste = "744,44 -> 117,671";
		* String[] testeArr = teste.split("\\,| \\-\\> ");
		*/
		// apenas usar (na 1 parte) as linhas em que x1=x2 e y1=y2
		// se x1=x2
		// marcamos todos os pontos de y1 a y2 com o x em comum (fica uma linha
		// vertical)
		// se y1=y2
		// marcamos todos os pontos de x1 a x2 com o y em comum (fica uma linha
		// horizontal)

		// se nem x1=x2 ou y1=y2 
			// vamos perguntar 
				//se x1 < x2
					// percorremos as linhas crescentemente
						// se y1 < y2 
							// percorremos as colunas crescentemente
						// se y1 > y2
							// percorremos as colunas decrescentemente
				// se x1 > x2
					// percorremos as linhas decrescentemente
						// se y1 > y2
							// percorremos as colunas decrescentemente
						// se y1 < y2
							// percorremos as colunas crescentemente
		//An entry like 1,1 -> 3,3 covers points 1,1, 2,2, and 3,3.
		//An entry like 9,7 -> 7,9 covers points 9,7, 8,8, and 7,9.
	}
}
/*
1.1....11.	1.1....11.	1.1....11.	1.1....11.
.111...2..	.111...2..	.111...2..	.111...2..
..2.1.111.	..2.1.111.	..2.1.111.	..2.1.111.
...1.2.2..	...1.2.2..	...1.2.2..	...1.2.2..
.112313211	.112313211	.112313211	.112313211
...1.2....	...1.2....	...1.2....	...1.2....
..1...1...	..1...1...	..1...1...	..1...1...
.1.....1..	.1.....1..	.1.....1..	.1.....1..
1.......1.	1.......1.	1.......1.	1.......1.
222111....	222111....	222111....	222111....



.......1..	.......1..	.......1..
..1....1..	..1....1..	..1....1..
..1....1..	..1....1..	..1....1..
.......1..	.......1..	.......1..
.112111211	.112111211	.112111211
..........	..........	..........
..........	..........	..........
..........	..........	..........
..........	..........	..........
222111....	222111....	222111....


*/
