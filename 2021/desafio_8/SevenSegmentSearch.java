package desafio_8;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
//ola
/*
 * 0: a b c e f g
 * 1: f c				->
 * 2: a c d e g
 * 3: a c d f g
 * 4: b c d f			->
 * 5: a b d f g
 * 6: a b d e f g
 * 7: a c f				->
 * 8: a b c d e f g		->
 * 9: a b c d f g
 */
public class SevenSegmentSearch {
	private static String input = "desafio_8\\input.txt";
	private static String inputTeste = "desafio_8\\input_teste.txt";
	private static String zero  = "abcefg";
	private static String one   = "cf";
	private static String two   = "acdeg";
	private static String three = "acdfg";
	private static String four  = "bcdf";
	private static String five  = "abdfg";
	private static String six   = "abdefg";
	private static String seven = "acf";
	private static String eight = "abcdefg";
	private static String nine  = "abcdfg";

	public static void main(String[] args) {
		String line;
		String[] left;
		String[] right;
		String[] partition;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputTeste)))) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				partition = line.split(" \\| ");
				left = partition[0].split(" ");
				ordena(left);
				for (int i = 0; i < left.length; i++) {
					//System.out.print(left[i] + " ");
				}
				//System.out.print("| ");
				right = partition[1].split(" ");
				ordena(right);
				for (int i = 0; i < right.length; i++) {
					//System.out.print(right[i] + " ");
				}
				//System.out.println("\n");
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("No file found!");
		}
	}

	public static void ordena(String[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				if (array[i].length() > array[j].length()) {
					troca(array, i, j);
				}
			}
		}
	}

	public static void troca(String[] array, int i, int j) {
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

/*
void swap(char** string_array, int posA, int posB) {
	char* temp = string_array[posA];
	string_array[posA] = string_array[posB];
	string_array[posB] = temp;
}

void bubble_sort(char** string_array, int size) {
	for (int i = 0; i < size - 1; i++) {
		for (int j = size - 1; j > i; j--) {
			if (strcmp(string_array[j - 1], string_array[j]) > 0) {
				swap(string_array, j - 1, j);
			}
		}
	}
}
*/

/*
 * 1 -> partir a linha em varias strings
 * 2 -> ordenar as strings por tamanhos
 * 3 -> procurar pelos tamanhos de 1,4,7,8
 */
