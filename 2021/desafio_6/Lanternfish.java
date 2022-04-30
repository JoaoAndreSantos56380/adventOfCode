package desafio_6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Lanternfish
 */
public class Lanternfish {
	private static String input = "input.txt";
	private static String inputTeste = "inputTeste.txt";
	public static void main(String[] args) {
		ArrayList<Integer> listaLanternFish = new ArrayList<>();
		String line;
		String[] lineArr;
		int size;
		long sum = 0L;
		int index;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputTeste)))) {
			//ler um valor do .txt
			line = br.readLine();
			lineArr = line.split(",");
			for (int i = 0; i < lineArr.length; i++) {
				//simular quantos filhos vai ter
				for (int j = 1; j <= 256; j++) {
					//somar o valor e repetir o processo para os filhos
					System.out.println("oal");
				}
			}
		} catch (IOException e) {
			System.out.println("No file found!");
		}
		//imprimir valor final
		System.out.println(sum);
	}
}
/*
	private static String input = "input.txt";
	private static String inputTeste = "inputTeste.txt";

	public static void main(String[] args) {
		ArrayList<Integer> listaLanternFish = new ArrayList<>();
		String line;
		String[] lineArr;
		int size;
		int index;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(inputTeste)))) {
			if ((line = br.readLine()) != null) {
				lineArr = line.split(",");
				for (int i = 0; i < lineArr.length; i++) {
					listaLanternFish.add(Integer.parseInt(lineArr[i]));
					for (int k = 1; k <= 256; k++) {
						size = listaLanternFish.size();
						System.out.println("iteracao " + k );
						for (int j = 0; j < size; j++) {
							index = listaLanternFish.get(j);
							if (index > 0) {
								listaLanternFish.set(j, --index);
							} else {
								listaLanternFish.set(j,  6);
								listaLanternFish.add(8);
							}
						}
					}
					listaLanternFish.clear();
				}
			}
			System.out.println(listaLanternFish.size());
		} catch (IOException e) {
			System.out.println("No file found!");
		}
	}
*/

		/*
		3,4,3,1,2
		3	tem	31 filhos		
			o 1 filho do 3 tem 30 filhos
			o 2 filhos do 3 tem 29
			o 3 (256-3)/8 = 31
			o 4 (256-11)/8 = 30
			o 5 (256-19)/8 = 29
			o 6 (256-27)/8 = 28
			o 7(256-35)/8 = 27
		*/
